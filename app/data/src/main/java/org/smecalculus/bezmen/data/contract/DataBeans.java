package org.smecalculus.bezmen.data.contract;

import org.smecalculus.bezmen.config.data.ConfigBeans;
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
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:mem:db;DB_CLOSE_DELAY=-1");
        dataSource.setUsername("sa");
        dataSource.setPassword("sa");
        return dataSource;
    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }
}
