package org.smecalculus.bezmen.core;

import org.smecalculus.bezmen.configuration.ConfigBeans;
import org.smecalculus.bezmen.validation.ValidationBeans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration(proxyBeanMethods = false)
@Import({ValidationBeans.class, ConfigBeans.class})
public class CoreBeans {

}
