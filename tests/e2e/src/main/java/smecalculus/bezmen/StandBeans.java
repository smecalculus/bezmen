package smecalculus.bezmen;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.http.HttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import smecalculus.bezmen.messaging.BezmenClient;
import smecalculus.bezmen.messaging.BezmenClientJavaHttp;

@Configuration(proxyBeanMethods = false)
public class StandBeans {

    @Bean
    BezmenClient bezmenClient() {
        ObjectMapper jsonMapper = new ObjectMapper();
        HttpClient client = HttpClient.newHttpClient();
        return new BezmenClientJavaHttp(jsonMapper, client);
    }
}
