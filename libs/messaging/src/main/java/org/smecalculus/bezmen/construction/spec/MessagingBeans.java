package org.smecalculus.bezmen.construction.spec;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration(proxyBeanMethods = false)
@Import({MessagingConfigBeans.class, WebSpringMvcBeans.class})
public class MessagingBeans {}
