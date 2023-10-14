package smecalculus.bezmen.construction;

import org.springframework.boot.actuate.autoconfigure.endpoint.EndpointAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.health.HealthEndpointAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.web.server.ManagementContextAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.web.servlet.ServletManagementContextAutoConfiguration;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import smecalculus.bezmen.configuration.MessageMappingMode;
import smecalculus.bezmen.configuration.MessagingProtocolMode;

@ConditionalOnMessagingProtocolModes(MessagingProtocolMode.HTTP)
@ConditionalOnMessageMappingModes(MessageMappingMode.SPRING_MANAGEMENT)
@ImportAutoConfiguration({
    ManagementContextAutoConfiguration.class,
    ServletManagementContextAutoConfiguration.class,
    EndpointAutoConfiguration.class,
    WebEndpointAutoConfiguration.class,
    HealthEndpointAutoConfiguration.class
})
@Configuration(proxyBeanMethods = false)
public class MappingSpringWebManagementBeans {}
