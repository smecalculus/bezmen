package org.smecalculus.bezmen.foo.data.beans;

import org.smecalculus.bezmen.foo.WeighingModelMapper;
import org.smecalculus.bezmen.foo.data.WeighingDao;
import org.smecalculus.bezmen.foo.data.WeighingDaoSpringDataImpl;
import org.smecalculus.bezmen.foo.data.springdata.WeighingRepository;
import org.smecalculus.bezmen.schema.SchemaBeans;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Import(SchemaBeans.class)
@Configuration(proxyBeanMethods = false)
@EnableTransactionManagement
@EnableJdbcRepositories(basePackages = "org.smecalculus.bezmen.foo.data.springdata")
public class WeighingDaoSpringDataH2Beans extends AbstractJdbcConfiguration {

    @Bean
    public WeighingDao underTest(WeighingModelMapper modelMapper, WeighingRepository repository) {
        return new WeighingDaoSpringDataImpl(modelMapper, repository);
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:mem:springdata;DB_CLOSE_DELAY=-1;DATABASE_TO_UPPER=false");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        return dataSource;
    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
