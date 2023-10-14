package smecalculus.bezmen.construction;

import com.typesafe.config.ConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import smecalculus.bezmen.configuration.ConfigKeeper;
import smecalculus.bezmen.configuration.ConfigKeeperLightbendConfig;
import smecalculus.bezmen.configuration.ConfigKeeperSpringConfig;
import smecalculus.bezmen.configuration.ConfigMappingMode;
import smecalculus.bezmen.configuration.ConfigProtocolMode;

@Configuration(proxyBeanMethods = false)
public class ConfigBeans {

    @Bean
    @ConditionalOnConfigProtocolMode(ConfigProtocolMode.FILE_SYSTEM)
    @ConditionalOnConfigMappingMode(ConfigMappingMode.LIGHTBEND_CONFIG)
    ConfigKeeper configKeeperLightbendConfig() {
        return new ConfigKeeperLightbendConfig(ConfigFactory.load());
    }

    @Bean
    @ConditionalOnConfigProtocolMode(ConfigProtocolMode.FILE_SYSTEM)
    @ConditionalOnConfigMappingMode(ConfigMappingMode.SPRING_CONFIG)
    ConfigKeeper configKeeperSpringConfig(Environment environment) {
        return new ConfigKeeperSpringConfig(environment);
    }
}
