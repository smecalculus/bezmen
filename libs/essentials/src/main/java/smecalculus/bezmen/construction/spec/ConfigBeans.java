package smecalculus.bezmen.construction.spec;

import com.typesafe.config.ConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import smecalculus.bezmen.configuration.impl.ConfigKeeperLightbendConfig;
import smecalculus.bezmen.configuration.spec.ConfigKeeper;
import smecalculus.bezmen.configuration.spec.ConfigMode;

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
