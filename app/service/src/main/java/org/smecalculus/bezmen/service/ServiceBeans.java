package org.smecalculus.bezmen.service;

import org.smecalculus.bezmen.core.CoreBeans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration(proxyBeanMethods = false)
@Import(CoreBeans.class)
public class ServiceBeans {
}
