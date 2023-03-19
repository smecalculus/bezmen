package com.smecalculus.bezmen.messaging;

import com.smecalculus.bezmen.messaging.model.MessagingProps;
import com.typesafe.config.Config;
import org.smecalculus.bezmen.core.CoreBeans;
import org.smecalculus.bezmen.core.validation.BezmenValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration(proxyBeanMethods = false)
@Import({CoreBeans.class})
@ComponentScan(basePackageClasses = {MessagingMapper.class})
public class MessagingBeans {

    @Bean
    MessagingConfig messagingConfig(Config config,
                                    BezmenValidator validator,
                                    MessagingMapper mapper) {
        return new MessagingConfigImpl(config, validator, mapper);
    }

    @Bean
    MessagingProps messagingProps(MessagingConfig config) {
        return config.getMessagingProps();
    }
}
