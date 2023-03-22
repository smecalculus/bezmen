package org.smecalculus.bezmen.data.beans;

import org.smecalculus.bezmen.data.SepulkaDao;
import org.smecalculus.bezmen.data.SepulkaDaoSpringData;
import org.smecalculus.bezmen.data.SepulkaRecMapper;
import org.smecalculus.bezmen.data.springdata.SepulkaRepository;
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
public class SepulkaDaoSpringDataH2Beans extends AbstractJdbcConfiguration {

    @Bean
    public SepulkaDao underTest(SepulkaRecMapper recMapper, SepulkaRepository repository) {
        return new SepulkaDaoSpringData(recMapper, repository);
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
