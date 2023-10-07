package smecalculus.bezmen.interior.construction;

import static smecalculus.bezmen.interior.configuration.StateMappingMode.SPRING_DATA;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.relational.core.dialect.Dialect;
import org.springframework.data.relational.core.dialect.H2Dialect;
import org.springframework.data.relational.core.dialect.PostgresDialect;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import smecalculus.bezmen.interior.configuration.StorageProps;
import smecalculus.bezmen.interior.configuration.StorageProtocolProps;

@Configuration(proxyBeanMethods = false)
@ConditionalOnStateMappingMode(SPRING_DATA)
@EnableJdbcRepositories("smecalculus.bezmen.interior.storage.springdata")
public class MappingSpringDataBeans extends AbstractJdbcConfiguration {

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public Dialect dialect(StorageProps storageProps) {
        StorageProtocolProps storageProtocolProps = storageProps.protocolProps();
        return switch (storageProtocolProps.protocolMode()) {
            case H2 -> H2Dialect.INSTANCE;
            case POSTGRES -> PostgresDialect.INSTANCE;
        };
    }
}
