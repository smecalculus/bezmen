package com.smecalculus.bezmen.construction;

import com.smecalculus.bezmen.configuration.*;
import org.smecalculus.bezmen.configuration.ConfigKeeper;
import org.smecalculus.bezmen.validation.BezmenValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class MessagingBeans {

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
