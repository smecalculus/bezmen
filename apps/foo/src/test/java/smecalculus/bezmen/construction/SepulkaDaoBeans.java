package smecalculus.bezmen.construction;

import static java.util.stream.Collectors.joining;
import static smecalculus.bezmen.configuration.OrmMode.MY_BATIS;
import static smecalculus.bezmen.configuration.OrmMode.SPRING_DATA;
import static smecalculus.bezmen.configuration.VendorMode.POSTGRES;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import smecalculus.bezmen.configuration.OrmProps;
import smecalculus.bezmen.configuration.StorageProps;
import smecalculus.bezmen.configuration.VendorProps;
import smecalculus.bezmen.storage.SepulkaDao;
import smecalculus.bezmen.storage.SepulkaDaoMyBatis;
import smecalculus.bezmen.storage.SepulkaDaoSpringData;
import smecalculus.bezmen.storage.SepulkaRecMapper;
import smecalculus.bezmen.storage.SepulkaRecMapperImpl;
import smecalculus.bezmen.storage.mybatis.SepulkaSqlMapper;
import smecalculus.bezmen.storage.springdata.SepulkaRepository;

@Configuration(proxyBeanMethods = false)
public class SepulkaDaoBeans {

    public static final String DB = "testdb";

    @Bean
    public DataSource dataSource(StorageProps storageProps) {
        List<String> common = List.of("DB_CLOSE_DELAY=-1");
        List<String> specific =
                switch (storageProps.vendorProps().mode()) {
                    case H2 -> List.of("MODE=STRICT");
                    case POSTGRES -> List.of("MODE=PostgreSQL", "DATABASE_TO_LOWER=TRUE", "DEFAULT_NULL_ORDERING=HIGH");
                };
        String nameWithSettings = Stream.of(List.of(DB), common, specific)
                .flatMap(Collection::stream)
                .collect(joining(";"));
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .setName(nameWithSettings)
                .addScript("/schemas/alfa/drop.sql")
                .addScript("/schemas/alfa/create.sql")
                .build();
    }

    @Bean
    public SepulkaRecMapper sepulkaRecMapper() {
        return new SepulkaRecMapperImpl();
    }

    @Configuration(proxyBeanMethods = false)
    public static class SpringDataPostgres {

        @Bean
        public SepulkaDao underTest(SepulkaRecMapper recMapper, SepulkaRepository repository) {
            return new SepulkaDaoSpringData(recMapper, repository);
        }

        @Bean
        public StorageProps dataProps() {
            return StorageProps.builder()
                    .ormProps(OrmProps.builder().mode(SPRING_DATA).build())
                    .vendorProps(VendorProps.builder().mode(POSTGRES).build())
                    .build();
        }
    }

    @Configuration(proxyBeanMethods = false)
    public static class MyBatisPostgres {

        @Bean
        public SepulkaDao underTest(SepulkaRecMapper recMapper, SepulkaSqlMapper sqlMapper) {
            return new SepulkaDaoMyBatis(recMapper, sqlMapper);
        }

        @Bean
        public StorageProps storageProps() {
            return StorageProps.builder()
                    .ormProps(OrmProps.builder().mode(MY_BATIS).build())
                    .vendorProps(VendorProps.builder().mode(POSTGRES).build())
                    .build();
        }
    }
}
