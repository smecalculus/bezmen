package org.smecalculus.bezmen.data.contract;

import org.smecalculus.bezmen.config.data.contract.ConfigBeans;
import org.smecalculus.bezmen.config.data.contract.DataProps;
import org.smecalculus.bezmen.config.data.contract.H2Props;
import org.smecalculus.bezmen.config.data.contract.PostgresProps;
import org.smecalculus.bezmen.data.impl.DmMapper;
import org.smecalculus.bezmen.data.impl.WeighingDaoImpl;
import org.smecalculus.bezmen.data.impl.WeighingRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@Import(ConfigBeans.class)
@ComponentScan(basePackageClasses = DmMapper.class)
@EnableJdbcRepositories(basePackages = "org.smecalculus.bezmen.data")
public class DataBeans extends AbstractJdbcConfiguration {

    @Bean
    public WeighingDao weighingDao(DmMapper mapper, WeighingRepository repository) {
        return new WeighingDaoImpl(mapper, repository);
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
