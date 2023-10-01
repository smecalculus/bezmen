package smecalculus.bezmen.construction;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import({
    MessagingConfigBeans.class,
    MappingSpringWebBeans.class,
    MappingSpringWebManagementBeans.class,
    ProtocolHttpBeans.class,
    ProtocolJmxBeans.class
})
@Configuration(proxyBeanMethods = false)
public class MessagingBeans {}
