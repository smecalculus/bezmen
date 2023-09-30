package smecalculus.bezmen.construction;

import static smecalculus.bezmen.configuration.MessageMappingMode.SPRING_WEB_MVC;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration(proxyBeanMethods = false)
@ConditionalOnMessageMappingMode(SPRING_WEB_MVC)
@EnableWebMvc
public class MappingSpringWebBeans {}
