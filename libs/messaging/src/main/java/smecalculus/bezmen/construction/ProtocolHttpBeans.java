package smecalculus.bezmen.construction;

import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import smecalculus.bezmen.configuration.MessagingProtocolMode;

@ConditionalOnMessagingProtocolModes(MessagingProtocolMode.HTTP)
@ImportAutoConfiguration({ServletWebServerFactoryAutoConfiguration.class, DispatcherServletAutoConfiguration.class})
@Configuration(proxyBeanMethods = false)
public class ProtocolHttpBeans {}
