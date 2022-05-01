package org.smecalculus.bezmen.web;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.smecalculus.bezmen.service.contract.ServiceBeans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Configuration
@Import(ServiceBeans.class)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public Config config() {
        return ConfigFactory.load();
    }
}
