package smecalculus.bezmen.interior.construction;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import smecalculus.bezmen.interior.configuration.MessageMappingMode;
import smecalculus.bezmen.interior.configuration.MessagingProtocolMode;

@ConditionalOnMessagingProtocolModes(MessagingProtocolMode.HTTP)
@ConditionalOnMessageMappingModes(MessageMappingMode.SPRING_MVC)
@EnableWebMvc
@Configuration(proxyBeanMethods = false)
public class MappingSpringWebMvcBeans {}
