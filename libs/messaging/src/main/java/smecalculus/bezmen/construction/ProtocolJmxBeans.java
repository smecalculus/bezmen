package smecalculus.bezmen.construction;

import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import smecalculus.bezmen.configuration.MessagingProtocolMode;

@ConditionalOnMessagingProtocolModes(MessagingProtocolMode.JMX)
@ImportAutoConfiguration({JmxAutoConfiguration.class})
@Configuration(proxyBeanMethods = false)
public class ProtocolJmxBeans {}
