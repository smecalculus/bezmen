package org.smecalculus.bezmen.data;

import org.smecalculus.bezmen.configuration.DataConfig;
import org.smecalculus.bezmen.configuration.DataConfigBeans;
import org.smecalculus.bezmen.configuration.DataProps;
import org.smecalculus.bezmen.configuration.H2Props;
import org.smecalculus.bezmen.configuration.PostgresProps;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Import(DataConfigBeans.class)
@Configuration(proxyBeanMethods = false)
public class DataBeans extends AbstractJdbcConfiguration {

    @Bean
    DataProps dataProps(DataConfig dataConfig) {
        return dataConfig.getDataProps();
    }

    @Bean
    public DataSource dataSource(DataProps dataProps) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        switch (dataProps.mode()) {
            case H2 -> configure(dataSource, dataProps.h2Props());
            case POSTGRES -> configure(dataSource, dataProps.postgresProps());
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
