package smecalculus.bezmen.construction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import smecalculus.bezmen.configuration.MessagingProps;
import smecalculus.bezmen.configuration.MessagingPropsEdge;
import smecalculus.bezmen.configuration.MessagingPropsMapper;
import smecalculus.bezmen.configuration.MessagingPropsMapperImpl;
import smecalculus.bezmen.configuration.PropsKeeper;
import smecalculus.bezmen.validation.EdgeValidator;

@PropertySource("classpath:messaging.properties")
@Configuration(proxyBeanMethods = false)
public class MessagingConfigBeans {

    private static final Logger LOG = LoggerFactory.getLogger(MessagingConfigBeans.class);

    @Bean
    MessagingPropsMapper messagingPropsMapper() {
        return new MessagingPropsMapperImpl();
    }

    @Bean
    MessagingProps messagingProps(PropsKeeper keeper, EdgeValidator validator, MessagingPropsMapper mapper) {
        var propsEdge = keeper.read("bezmen.messaging", MessagingPropsEdge.class);
        validator.validate(propsEdge);
        LOG.info("Read {}", propsEdge);
        return mapper.toDomain(propsEdge);
    }
}
