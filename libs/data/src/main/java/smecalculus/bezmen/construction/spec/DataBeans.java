package smecalculus.bezmen.construction.spec;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import smecalculus.bezmen.configuration.spec.DataProps;
import smecalculus.bezmen.configuration.spec.H2Props;
import smecalculus.bezmen.configuration.spec.PostgresProps;
import smecalculus.bezmen.configuration.spec.VendorProps;

@Configuration(proxyBeanMethods = false)
@Import({DataConfigBeans.class, OrmMyBatisBeans.class, OrmSpringDataBeans.class})
public class DataBeans {

    @Bean
    public DataSource dataSource(DataProps dataProps) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        VendorProps vendorProps = dataProps.vendorProps();
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
