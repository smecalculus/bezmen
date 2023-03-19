package org.smecalculus.bezmen.core.configuration;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class ConfigBeans {

    @Bean
    Config config() {
        return ConfigFactory.load();
    }
}
