package smecalculus.bezmen.construction.spec;

import static java.util.stream.Collectors.joining;
import static smecalculus.bezmen.configuration.spec.OrmMode.MY_BATIS;
import static smecalculus.bezmen.configuration.spec.OrmMode.SPRING_DATA;
import static smecalculus.bezmen.configuration.spec.VendorMode.POSTGRES;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import smecalculus.bezmen.configuration.spec.DataProps;
import smecalculus.bezmen.configuration.spec.OrmProps;
import smecalculus.bezmen.configuration.spec.VendorProps;
import smecalculus.bezmen.data.impl.SepulkaDaoMyBatis;
import smecalculus.bezmen.data.impl.SepulkaDaoSpringData;
import smecalculus.bezmen.data.spec.SepulkaDao;
import smecalculus.bezmen.data.spec.SepulkaRecMapper;
import smecalculus.bezmen.data.spec.SepulkaRecMapperImpl;
import smecalculus.bezmen.data.spec.mybatis.SepulkaSqlMapper;
import smecalculus.bezmen.data.spec.springdata.SepulkaRepository;

@Configuration(proxyBeanMethods = false)
public class SepulkaDaoBeans {

    public static final String DB = "testdb";

    @Bean
    public DataSource dataSource(DataProps dataProps) {
        List<String> common = List.of("DB_CLOSE_DELAY=-1");
        List<String> specific =
                switch (dataProps.vendorProps().mode()) {
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
        public DataProps dataProps() {
            return DataProps.builder()
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
        public DataProps dataProps() {
            return DataProps.builder()
                    .ormProps(OrmProps.builder().mode(MY_BATIS).build())
                    .vendorProps(VendorProps.builder().mode(POSTGRES).build())
                    .build();
        }
    }
}