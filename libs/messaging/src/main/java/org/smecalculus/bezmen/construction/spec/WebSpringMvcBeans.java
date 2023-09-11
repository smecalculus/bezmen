package org.smecalculus.bezmen.construction.spec;

import static org.smecalculus.bezmen.configuration.spec.WebMode.SPRING_MVC;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration(proxyBeanMethods = false)
@ConditionalOnWebMode(SPRING_MVC)
@EnableWebMvc
public class WebSpringMvcBeans {}
