package smecalculus.bezmen.interior.construction;

import com.typesafe.config.ConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import smecalculus.bezmen.interior.configuration.ConfigKeeper;
import smecalculus.bezmen.interior.configuration.ConfigKeeperLightbendConfig;
import smecalculus.bezmen.interior.configuration.ConfigKeeperSpringConfig;
import smecalculus.bezmen.interior.configuration.ConfigMappingMode;
import smecalculus.bezmen.interior.configuration.ConfigProtocolMode;

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
