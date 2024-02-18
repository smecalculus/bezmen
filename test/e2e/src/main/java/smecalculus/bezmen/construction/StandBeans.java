package smecalculus.bezmen.construction;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.http.HttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import smecalculus.bezmen.configuration.ClientKeys;
import smecalculus.bezmen.configuration.ClientProps;
import smecalculus.bezmen.messaging.BezmenClient;
import smecalculus.bezmen.messaging.BezmenClientJavaHttp;

@Configuration(proxyBeanMethods = false)
public class StandBeans {

    @Bean
    ClientProps clientProps(Environment environment) {
        var host = environment.getRequiredProperty(ClientKeys.HOST_KEY, String.class);
        var port = environment.getRequiredProperty(ClientKeys.POST_KEY, Integer.class);
        return new ClientProps(host, port);
    }

    @Bean
    BezmenClient bezmenClient(ClientProps clientProps) {
        var jsonMapper = new ObjectMapper();
        var httpClient = HttpClient.newHttpClient();
        return new BezmenClientJavaHttp(clientProps, jsonMapper, httpClient);
    }
}
