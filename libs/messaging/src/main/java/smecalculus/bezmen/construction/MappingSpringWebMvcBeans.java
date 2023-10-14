package smecalculus.bezmen.construction;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import smecalculus.bezmen.configuration.MessageMappingMode;
import smecalculus.bezmen.configuration.MessagingProtocolMode;

@ConditionalOnMessagingProtocolModes(MessagingProtocolMode.HTTP)
@ConditionalOnMessageMappingModes(MessageMappingMode.SPRING_MVC)
@EnableWebMvc
@Configuration(proxyBeanMethods = false)
public class MappingSpringWebMvcBeans {}
