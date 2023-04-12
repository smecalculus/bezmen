package org.smecalculus.bezmen.operation;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration(proxyBeanMethods = false)
@Import({ValidationBeans.class, ConfigBeans.class})
public class CoreBeans {

}
