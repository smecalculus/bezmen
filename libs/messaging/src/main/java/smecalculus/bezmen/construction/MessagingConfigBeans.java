package smecalculus.bezmen.construction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import smecalculus.bezmen.configuration.ConfigKeeper;
import smecalculus.bezmen.configuration.MessagingCfgMapper;
import smecalculus.bezmen.configuration.MessagingCfgMapperImpl;
import smecalculus.bezmen.configuration.MessagingProps;
import smecalculus.bezmen.configuration.MessagingPropsCfg;
import smecalculus.bezmen.validation.EdgeValidator;

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
