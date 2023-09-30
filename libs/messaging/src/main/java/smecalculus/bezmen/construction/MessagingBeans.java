package smecalculus.bezmen.construction;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration(proxyBeanMethods = false)
@Import({MessagingConfigBeans.class, MappingSpringWebBeans.class, ProtocolHttpBeans.class})
public class MessagingBeans {}
