package org.smecalculus.bezmen.foo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration(proxyBeanMethods = false)
@Import({
        FooBeans.class
})
@SpringBootApplication(
        exclude = LiquibaseAutoConfiguration.class
)
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
