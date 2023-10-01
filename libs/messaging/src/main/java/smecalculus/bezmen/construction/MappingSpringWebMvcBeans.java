package smecalculus.bezmen.construction;

import static smecalculus.bezmen.configuration.MessageMappingMode.SPRING_MVC;
import static smecalculus.bezmen.configuration.MessagingProtocolMode.HTTP;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ConditionalOnMessagingProtocolModes(HTTP)
@ConditionalOnMessageMappingModes(SPRING_MVC)
@EnableWebMvc
@Configuration(proxyBeanMethods = false)
public class MappingSpringWebMvcBeans {}
