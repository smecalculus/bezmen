package org.smecalculus.bezmen.construction;

import com.typesafe.config.ConfigFactory;
import org.smecalculus.bezmen.configuration.ConfigKeeper;
import org.smecalculus.bezmen.configuration.ConfigKeeperLightbendConfig;
import org.smecalculus.bezmen.configuration.ConfigMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class ConfigBeans {

    @Bean
    ConfigKeeper configKeeper() {
        String configMode = System.getProperty("bezmen.config.mode", ConfigMode.FILE_SYSTEM.name());
        return switch (ConfigMode.valueOf(configMode.toUpperCase())) {
            case FILE_SYSTEM -> new ConfigKeeperLightbendConfig(ConfigFactory.load());
        };
    }
}
