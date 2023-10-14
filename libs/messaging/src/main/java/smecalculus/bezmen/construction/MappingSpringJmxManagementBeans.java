package smecalculus.bezmen.construction;

import org.springframework.context.annotation.Configuration;
import smecalculus.bezmen.configuration.MessageMappingMode;
import smecalculus.bezmen.configuration.MessagingProtocolMode;

@ConditionalOnMessagingProtocolModes(MessagingProtocolMode.JMX)
@ConditionalOnMessageMappingModes(MessageMappingMode.SPRING_MANAGEMENT)
@Configuration(proxyBeanMethods = false)
public class MappingSpringJmxManagementBeans {}
