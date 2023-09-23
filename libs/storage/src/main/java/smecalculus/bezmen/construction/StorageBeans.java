package smecalculus.bezmen.construction;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import smecalculus.bezmen.configuration.H2Props;
import smecalculus.bezmen.configuration.PostgresProps;
import smecalculus.bezmen.configuration.StorageProps;
import smecalculus.bezmen.configuration.VendorProps;

@Configuration(proxyBeanMethods = false)
@Import({StorageConfigBeans.class, OrmMyBatisBeans.class, OrmSpringDataBeans.class})
public class StorageBeans {

    @Bean
    public DataSource dataSource(StorageProps storageProps) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        VendorProps vendorProps = storageProps.vendorProps();
        switch (vendorProps.mode()) {
            case H2 -> configure(dataSource, vendorProps.h2Props());
            case POSTGRES -> configure(dataSource, vendorProps.postgresProps());
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
