package org.smecalculus.bezmen.construction;

import org.smecalculus.bezmen.data.SepulkaDao;
import org.smecalculus.bezmen.data.SepulkaDaoMyBatis;
import org.smecalculus.bezmen.data.SepulkaDaoSpringData;
import org.smecalculus.bezmen.data.SepulkaRecMapper;
import org.smecalculus.bezmen.data.SepulkaRecMapperImpl;
import org.smecalculus.bezmen.data.mybatis.SepulkaSqlMapper;
import org.smecalculus.bezmen.data.springdata.SepulkaRepository;
import org.smecalculus.bezmen.modeling.DataProps;
import org.smecalculus.bezmen.modeling.OrmMode;
import org.smecalculus.bezmen.modeling.OrmProps;
import org.smecalculus.bezmen.modeling.VendorMode;
import org.smecalculus.bezmen.modeling.VendorProps;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import javax.sql.DataSource;

import static java.lang.String.format;
import static org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType.H2;

@Configuration(proxyBeanMethods = false)
public class SepulkaDaoBeans {

    @Bean
    public DataSource dataSource(DataProps dataProps) {
        String h2mode = switch (dataProps.vendorProps().mode()) {
            case H2 -> "STRICT";
            case POSTGRES -> "PostgreSQL";
        };
        String nameWithParams = String.join(";",
                "testdb",
                format("MODE=%s", h2mode),
                "DB_CLOSE_DELAY=-1",
                "DATABASE_TO_LOWER=TRUE",
                "DEFAULT_NULL_ORDERING=HIGH"
        );
        return new EmbeddedDatabaseBuilder()
                .setType(H2)
                .setName(nameWithParams)
                .addScript("schemas/alfa/wipe.sql")
                .addScript("schemas/alfa/schema.sql")
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
                    .ormProps(OrmProps.builder()
                            .mode(OrmMode.SPRING_DATA)
                            .build())
                    .vendorProps(VendorProps.builder()
                            .mode(VendorMode.POSTGRES)
                            .build())
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
                    .ormProps(OrmProps.builder()
                            .mode(OrmMode.MY_BATIS)
                            .build())
                    .vendorProps(VendorProps.builder()
                            .mode(VendorMode.POSTGRES)
                            .build())
                    .build();
        }
    }
}
