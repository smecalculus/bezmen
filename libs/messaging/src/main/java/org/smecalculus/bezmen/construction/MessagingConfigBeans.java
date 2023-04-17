package org.smecalculus.bezmen.construction;

import org.smecalculus.bezmen.configuration.ConfigKeeper;
import org.smecalculus.bezmen.configuration.MessagingCfgMapper;
import org.smecalculus.bezmen.configuration.MessagingCfgMapperImpl;
import org.smecalculus.bezmen.configuration.MessagingConfig;
import org.smecalculus.bezmen.configuration.MessagingConfigImpl;
import org.smecalculus.bezmen.configuration.MessagingProps;
import org.smecalculus.bezmen.validation.BezmenValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class MessagingConfigBeans {

    @Bean
    MessagingCfgMapper messagingCfgMapper() {
        return new MessagingCfgMapperImpl();
    }

    @Bean
    MessagingConfig messagingConfig(ConfigKeeper keeper,
                                    BezmenValidator validator,
                                    MessagingCfgMapper mapper) {
        return new MessagingConfigImpl(keeper, validator, mapper);
    }

    @Bean
    MessagingProps messagingProps(MessagingConfig config) {
        return config.getMessagingProps();
    }
}
