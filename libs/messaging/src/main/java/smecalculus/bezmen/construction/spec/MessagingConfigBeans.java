package smecalculus.bezmen.construction.spec;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import smecalculus.bezmen.configuration.impl.MessagingConfigImpl;
import smecalculus.bezmen.configuration.spec.ConfigKeeper;
import smecalculus.bezmen.configuration.spec.MessagingCfgMapper;
import smecalculus.bezmen.configuration.spec.MessagingCfgMapperImpl;
import smecalculus.bezmen.configuration.spec.MessagingConfig;
import smecalculus.bezmen.configuration.spec.MessagingProps;
import smecalculus.bezmen.validation.spec.BezmenValidator;

@Configuration(proxyBeanMethods = false)
public class MessagingConfigBeans {

    @Bean
    MessagingCfgMapper messagingCfgMapper() {
        return new MessagingCfgMapperImpl();
    }

    @Bean
    MessagingConfig messagingConfig(ConfigKeeper keeper, BezmenValidator validator, MessagingCfgMapper mapper) {
        return new MessagingConfigImpl(keeper, validator, mapper);
    }

    @Bean
    MessagingProps messagingProps(MessagingConfig config) {
        return config.getMessagingProps();
    }
}
