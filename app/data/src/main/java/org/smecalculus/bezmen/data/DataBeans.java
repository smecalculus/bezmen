package org.smecalculus.bezmen.data;

import com.typesafe.config.Config;
import org.smecalculus.bezmen.core.CoreBeans;
import org.smecalculus.bezmen.core.validation.BezmenValidator;
import org.smecalculus.bezmen.data.model.DataProps;
import org.smecalculus.bezmen.data.model.H2Props;
import org.smecalculus.bezmen.data.model.PostgresProps;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Import(CoreBeans.class)
@Configuration(proxyBeanMethods = false)
public class DataBeans extends AbstractJdbcConfiguration {

    @Bean
    DataMapper dataMapper() {
        return new DataMapperImpl();
    }

    @Bean
    DataConfig dataConfig(Config config, BezmenValidator validator, DataMapper mapper) {
        return new DataConfigImpl(config, validator, mapper);
    }

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
