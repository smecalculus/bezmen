package com.smecalculus.bezmen.messaging;

import com.smecalculus.bezmen.messaging.config.DefaultMessagingConfig;
import com.smecalculus.bezmen.messaging.config.MessagingCmMapper;
import com.smecalculus.bezmen.messaging.config.MessagingConfig;
import com.smecalculus.bezmen.messaging.config.MessagingProps;
import com.typesafe.config.Config;
import org.smecalculus.bezmen.core.CoreBeans;
import org.smecalculus.bezmen.core.validation.BezmenValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration(proxyBeanMethods = false)
@Import({CoreBeans.class})
@ComponentScan(basePackageClasses = {MessagingCmMapper.class})
public class MessagingBeans {

    @Bean
    MessagingConfig messagingConfig(Config config,
                                    BezmenValidator validator,
                                    MessagingCmMapper mapper) {
        return new DefaultMessagingConfig(config, validator, mapper);
    }

    @Bean
    MessagingProps messagingProps(MessagingConfig config) {
        return config.getMessagingProps();
    }
}
