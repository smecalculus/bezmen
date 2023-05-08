package org.smecalculus.bezmen.construction;

import org.smecalculus.bezmen.modeling.DataProps;
import org.smecalculus.bezmen.modeling.VendorProps;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.relational.core.dialect.Dialect;
import org.springframework.data.relational.core.dialect.H2Dialect;
import org.springframework.data.relational.core.dialect.PostgresDialect;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

import static org.smecalculus.bezmen.modeling.OrmMode.SPRING_DATA;

@Configuration(proxyBeanMethods = false)
@ConditionalOnOrmMode(SPRING_DATA)
@EnableJdbcRepositories("org.smecalculus.bezmen.data.springdata")
public class OrmSpringDataBeans {

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    public Dialect dialect(DataProps dataProps) {
        VendorProps vendorProps = dataProps.vendorProps();
        return switch (vendorProps.mode()) {
            case H2 -> H2Dialect.INSTANCE;
            case POSTGRES -> PostgresDialect.INSTANCE;
        };
    }
}
