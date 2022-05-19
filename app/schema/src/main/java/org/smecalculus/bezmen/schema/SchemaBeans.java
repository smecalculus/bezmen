package org.smecalculus.bezmen.schema;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

public class SchemaBeans {

    @Bean
    public SpringLiquibase liquibase(DataSource dataSource) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource);
        liquibase.setChangeLog("classpath:/postgres/owner/changelog.yml");
        return liquibase;
    }
}
