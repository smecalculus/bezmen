package org.smecalculus.bezmen.data;

import org.smecalculus.bezmen.data.springdata.SepulkaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.relational.core.dialect.Dialect;
import org.springframework.data.relational.core.dialect.PostgresDialect;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@ContextConfiguration
public class SepulkaDaoSpringDataH2IT extends SepulkaDaoIT {

    @Configuration
    @EnableTransactionManagement
    @EnableJdbcRepositories(basePackages = "org.smecalculus.bezmen.data.springdata")
    static class Beans extends AbstractJdbcConfiguration {
        @Bean
        public SepulkaDaoSpringData underTest(SepulkaRecMapper recMapper, SepulkaRepository repository) {
            return new SepulkaDaoSpringData(recMapper, repository);
        }

        @Bean
        public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) {
            return new NamedParameterJdbcTemplate(dataSource);
        }

        @Bean
        public PlatformTransactionManager transactionManager(DataSource dataSource) {
            return new DataSourceTransactionManager(dataSource);
        }

        @Override
        public Dialect jdbcDialect(NamedParameterJdbcOperations operations) {
            return PostgresDialect.INSTANCE;
        }
    }
}
