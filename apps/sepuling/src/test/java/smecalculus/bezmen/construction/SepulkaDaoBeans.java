package smecalculus.bezmen.construction;

import static java.util.stream.Collectors.joining;
import static smecalculus.bezmen.configuration.StateMappingMode.MY_BATIS;
import static smecalculus.bezmen.configuration.StateMappingMode.SPRING_DATA;
import static smecalculus.bezmen.configuration.StorageProtocolMode.POSTGRES;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import smecalculus.bezmen.configuration.StateMappingProps;
import smecalculus.bezmen.configuration.StorageProps;
import smecalculus.bezmen.configuration.StorageProtocolProps;
import smecalculus.bezmen.storage.SepulkaDao;
import smecalculus.bezmen.storage.SepulkaDaoMyBatis;
import smecalculus.bezmen.storage.SepulkaDaoSpringData;
import smecalculus.bezmen.storage.SepulkaStateMapper;
import smecalculus.bezmen.storage.SepulkaStateMapperImpl;
import smecalculus.bezmen.storage.mybatis.SepulkaSqlMapper;
import smecalculus.bezmen.storage.springdata.SepulkaRepository;

@Configuration(proxyBeanMethods = false)
public class SepulkaDaoBeans {

    public static final String DB = "testdb";

    @Bean
    public DataSource dataSource(StorageProps storageProps) {
        var common = List.of("DB_CLOSE_DELAY=-1");
        var specific =
                switch (storageProps.protocolProps().protocolMode()) {
                    case H2 -> List.of("MODE=STRICT");
                    case POSTGRES -> List.of("MODE=PostgreSQL", "DATABASE_TO_LOWER=TRUE", "DEFAULT_NULL_ORDERING=HIGH");
                };
        var nameWithSettings = Stream.of(List.of(DB), common, specific)
                .flatMap(Collection::stream)
                .collect(joining(";"));
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .setName(nameWithSettings)
                .addScript("/schemas/sepulkarium/drop.sql")
                .addScript("/schemas/sepulkarium/create.sql")
                .build();
    }

    @Bean
    public SepulkaStateMapper sepulkaStateMapper() {
        return new SepulkaStateMapperImpl();
    }

    @Configuration(proxyBeanMethods = false)
    public static class SpringDataPostgres {

        @Bean
        public SepulkaDao underTest(SepulkaStateMapper mapper, SepulkaRepository repository) {
            return new SepulkaDaoSpringData(mapper, repository);
        }

        @Bean
        public StorageProps storageProps() {
            return StorageProps.builder()
                    .mappingProps(
                            StateMappingProps.builder().mappingMode(SPRING_DATA).build())
                    .protocolProps(StorageProtocolProps.builder()
                            .protocolMode(POSTGRES)
                            .build())
                    .build();
        }
    }

    @Configuration(proxyBeanMethods = false)
    public static class MyBatisPostgres {

        @Bean
        public SepulkaDao underTest(SepulkaStateMapper stateMapper, SepulkaSqlMapper sqlMapper) {
            return new SepulkaDaoMyBatis(stateMapper, sqlMapper);
        }

        @Bean
        public StorageProps storageProps() {
            return StorageProps.builder()
                    .mappingProps(
                            StateMappingProps.builder().mappingMode(MY_BATIS).build())
                    .protocolProps(StorageProtocolProps.builder()
                            .protocolMode(POSTGRES)
                            .build())
                    .build();
        }
    }
}
