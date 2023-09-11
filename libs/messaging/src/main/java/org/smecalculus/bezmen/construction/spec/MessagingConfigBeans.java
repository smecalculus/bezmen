package org.smecalculus.bezmen.construction.spec;

import org.smecalculus.bezmen.configuration.impl.MessagingConfigImpl;
import org.smecalculus.bezmen.configuration.spec.ConfigKeeper;
import org.smecalculus.bezmen.configuration.spec.MessagingCfgMapper;
import org.smecalculus.bezmen.configuration.spec.MessagingCfgMapperImpl;
import org.smecalculus.bezmen.configuration.spec.MessagingConfig;
import org.smecalculus.bezmen.configuration.spec.MessagingProps;
import org.smecalculus.bezmen.validation.spec.BezmenValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
