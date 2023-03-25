package com.smecalculus.bezmen.messaging;

import com.smecalculus.bezmen.configuration.MessagingCfgMapper;
import com.smecalculus.bezmen.configuration.MessagingConfig;
import com.smecalculus.bezmen.configuration.MessagingConfigImpl;
import com.smecalculus.bezmen.configuration.MessagingProps;
import org.smecalculus.bezmen.configuration.ConfigKeeper;
import org.smecalculus.bezmen.core.CoreBeans;
import org.smecalculus.bezmen.validation.BezmenValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration(proxyBeanMethods = false)
@Import({CoreBeans.class})
@ComponentScan(basePackageClasses = {MessagingCfgMapper.class})
public class MessagingBeans {

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
