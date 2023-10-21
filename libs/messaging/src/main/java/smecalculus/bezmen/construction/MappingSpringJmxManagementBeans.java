package smecalculus.bezmen.construction;

import org.springframework.context.annotation.Configuration;
import smecalculus.bezmen.configuration.MessagingMappingMode;
import smecalculus.bezmen.configuration.MessagingProtocolMode;

@ConditionalOnMessagingProtocolModes(MessagingProtocolMode.JMX)
@ConditionalOnMessageMappingModes(MessagingMappingMode.SPRING_MANAGEMENT)
@Configuration(proxyBeanMethods = false)
public class MappingSpringJmxManagementBeans {}
