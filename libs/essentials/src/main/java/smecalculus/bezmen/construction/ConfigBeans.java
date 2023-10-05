package smecalculus.bezmen.construction;

import static smecalculus.bezmen.configuration.ConfigMappingMode.LIGHTBEND_CONFIG;
import static smecalculus.bezmen.configuration.ConfigMappingMode.SPRING_CONFIG;
import static smecalculus.bezmen.configuration.ConfigProtocolMode.FILE_SYSTEM;

import com.typesafe.config.ConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import smecalculus.bezmen.configuration.ConfigKeeper;
import smecalculus.bezmen.configuration.ConfigKeeperLightbendConfig;
import smecalculus.bezmen.configuration.ConfigKeeperSpringConfig;

@Configuration(proxyBeanMethods = false)
public class ConfigBeans {

    @Bean
    @ConditionalOnConfigProtocolMode(FILE_SYSTEM)
    @ConditionalOnConfigMappingMode(LIGHTBEND_CONFIG)
    ConfigKeeper configKeeperLightbendConfig() {
        return new ConfigKeeperLightbendConfig(ConfigFactory.load());
    }

    @Bean
    @ConditionalOnConfigProtocolMode(FILE_SYSTEM)
    @ConditionalOnConfigMappingMode(SPRING_CONFIG)
    ConfigKeeper configKeeperSpringConfig(Environment environment) {
        return new ConfigKeeperSpringConfig(environment);
    }
}
