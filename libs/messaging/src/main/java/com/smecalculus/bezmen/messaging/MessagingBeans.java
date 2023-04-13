package com.smecalculus.bezmen.messaging;

import com.smecalculus.bezmen.configuration.*;
import org.smecalculus.bezmen.configuration.ConfigKeeper;
import org.smecalculus.bezmen.construction.CoreBeans;
import org.smecalculus.bezmen.validation.BezmenValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration(proxyBeanMethods = false)
@Import({CoreBeans.class})
public class MessagingBeans {

    @Bean
    MessagingCfgMapper messagingMapper() {
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
