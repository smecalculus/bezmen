package smecalculus.bezmen.construction;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import smecalculus.bezmen.configuration.ConfigKeeper;
import smecalculus.bezmen.configuration.MessagingCfgMapper;
import smecalculus.bezmen.configuration.MessagingCfgMapperImpl;
import smecalculus.bezmen.configuration.MessagingConfig;
import smecalculus.bezmen.configuration.MessagingConfigImpl;
import smecalculus.bezmen.configuration.MessagingProps;
import smecalculus.bezmen.validation.EdgeValidator;

@Configuration(proxyBeanMethods = false)
public class MessagingConfigBeans {

    @Bean
    MessagingCfgMapper messagingCfgMapper() {
        return new MessagingCfgMapperImpl();
    }

    @Bean
    MessagingConfig messagingConfig(ConfigKeeper keeper, EdgeValidator validator, MessagingCfgMapper mapper) {
        return new MessagingConfigImpl(keeper, validator, mapper);
    }

    @Bean
    MessagingProps messagingProps(MessagingConfig config) {
        return config.getMessagingProps();
    }
}
