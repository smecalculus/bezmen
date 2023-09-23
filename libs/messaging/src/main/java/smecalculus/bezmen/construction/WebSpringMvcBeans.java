package smecalculus.bezmen.construction;

import static smecalculus.bezmen.configuration.WebMode.SPRING_MVC;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration(proxyBeanMethods = false)
@ConditionalOnWebMode(SPRING_MVC)
@EnableWebMvc
public class WebSpringMvcBeans {}
