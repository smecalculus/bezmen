package smecalculus.bezmen.interior.construction;

import static smecalculus.bezmen.interior.configuration.MessageMappingMode.SPRING_MANAGEMENT;
import static smecalculus.bezmen.interior.configuration.MessagingProtocolMode.JMX;

import org.springframework.context.annotation.Configuration;

@ConditionalOnMessagingProtocolModes(JMX)
@ConditionalOnMessageMappingModes(SPRING_MANAGEMENT)
@Configuration(proxyBeanMethods = false)
public class MappingSpringJmxManagementBeans {}
