package smecalculus.bezmen.interior.construction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import smecalculus.bezmen.interior.configuration.ConfigKeeper;
import smecalculus.bezmen.interior.configuration.MessagingCfgMapper;
import smecalculus.bezmen.interior.configuration.MessagingCfgMapperImpl;
import smecalculus.bezmen.interior.configuration.MessagingProps;
import smecalculus.bezmen.interior.configuration.MessagingPropsCfg;
import smecalculus.bezmen.interior.validation.EdgeValidator;

@PropertySource("classpath:messaging.properties")
@Configuration(proxyBeanMethods = false)
public class MessagingConfigBeans {

    private static final Logger LOG = LoggerFactory.getLogger(MessagingConfigBeans.class);

    @Bean
    MessagingCfgMapper messagingCfgMapper() {
        return new MessagingCfgMapperImpl();
    }

    @Bean
    MessagingProps messagingProps(ConfigKeeper keeper, EdgeValidator validator, MessagingCfgMapper mapper) {
        MessagingPropsCfg propsCfg = keeper.read("bezmen.messaging", MessagingPropsCfg.class);
        validator.validate(propsCfg);
        LOG.info("Read {}", propsCfg);
        return mapper.toDomain(propsCfg);
    }
}
