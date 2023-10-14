package smecalculus.bezmen.construction;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import smecalculus.bezmen.configuration.H2Props;
import smecalculus.bezmen.configuration.PostgresProps;
import smecalculus.bezmen.configuration.StorageProps;
import smecalculus.bezmen.configuration.StorageProtocolProps;

@Configuration(proxyBeanMethods = false)
@Import({StorageConfigBeans.class, MappingMyBatisBeans.class, MappingSpringDataBeans.class})
public class StorageBeans {

    @Bean
    public DataSource dataSource(StorageProps storageProps) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        StorageProtocolProps storageProtocolProps = storageProps.protocolProps();
        switch (storageProtocolProps.protocolMode()) {
            case H2 -> configure(dataSource, storageProtocolProps.h2Props());
            case POSTGRES -> configure(dataSource, storageProtocolProps.postgresProps());
        }
        return dataSource;
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
