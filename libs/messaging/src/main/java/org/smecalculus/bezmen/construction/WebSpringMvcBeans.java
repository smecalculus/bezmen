package org.smecalculus.bezmen.construction;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.smecalculus.bezmen.configuration.WebMode.SPRING_MVC;

@Configuration(proxyBeanMethods = false)
@ConditionalOnWebMode(SPRING_MVC)
@EnableWebMvc
public class WebSpringMvcBeans {
}
