package smecalculus.bezmen.construction;

import static smecalculus.bezmen.configuration.MessageMappingMode.SPRING_WEB_MVC;
import static smecalculus.bezmen.configuration.MessagingProtocolMode.HTTP;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ConditionalOnMessagingProtocolMode(HTTP)
@ConditionalOnMessageMappingMode(SPRING_WEB_MVC)
@EnableWebMvc
@Configuration(proxyBeanMethods = false)
public class MappingSpringWebBeans {}
