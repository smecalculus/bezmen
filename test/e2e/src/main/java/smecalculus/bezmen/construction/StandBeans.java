package smecalculus.bezmen.construction;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.http.HttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import smecalculus.bezmen.configuration.ClientProps;
import smecalculus.bezmen.configuration.TestingProps;
import smecalculus.bezmen.messaging.BezmenClient;
import smecalculus.bezmen.messaging.BezmenClientJavaHttp;

@Configuration(proxyBeanMethods = false)
public class StandBeans {

    @Bean
    ClientProps clientProps(Environment environment) {
        var host = environment.getRequiredProperty(TestingProps.HOST_KEY, String.class);
        var port = environment.getRequiredProperty(TestingProps.PORT_KEY, Integer.class);
        return new ClientProps(host, port);
    }

    @Bean
    BezmenClient bezmenClient(ClientProps clientProps) {
        var jsonMapper = new ObjectMapper();
        var httpClient = HttpClient.newHttpClient();
        return new BezmenClientJavaHttp(clientProps, jsonMapper, httpClient);
    }
}
