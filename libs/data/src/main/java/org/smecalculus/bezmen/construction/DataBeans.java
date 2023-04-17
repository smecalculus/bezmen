package org.smecalculus.bezmen.construction;

import org.smecalculus.bezmen.modeling.DataProps;
import org.smecalculus.bezmen.modeling.H2Props;
import org.smecalculus.bezmen.modeling.PostgresProps;
import org.smecalculus.bezmen.modeling.VendorProps;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration(proxyBeanMethods = false)
@Import({DataConfigBeans.class, OrmMyBatisBeans.class, OrmSpringDataBeans.class})
public class DataBeans {

    @Bean
    public DataSource dataSource(DataProps dataProps) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        VendorProps vendorProps = dataProps.vendorProps();
        switch (vendorProps.mode()) {
            case H2 -> configure(dataSource, vendorProps.h2Props());
            case POSTGRES -> configure(dataSource, vendorProps.postgresProps());
        }
        return dataSource;
    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    private void configure(DriverManagerDataSource dataSource, H2Props props) {
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl(props.url());
        dataSource.setUsername(props.username());
        dataSource.setPassword(props.password());
    }

    private void configure(DriverManagerDataSource dataSource, PostgresProps props) {
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl(props.url());
        dataSource.setUsername(props.username());
        dataSource.setPassword(props.password());
    }
}
