package org.smecalculus.bezmen.construction;

import static org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType.H2;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

@Configuration(proxyBeanMethods = false)
public class TestingBeans {

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(H2)
                .setName("testdb;DB_CLOSE_DELAY=-1;DATABASE_TO_UPPER=false;CASE_INSENSITIVE_IDENTIFIERS=true")
                .addScript("schemas/alfa/wipe.sql")
                .addScript("schemas/alfa/schema.sql")
                .build();
    }
}
