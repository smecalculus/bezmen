package org.smecalculus.bezmen;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.http.HttpClient;
import org.smecalculus.bezmen.messaging.impl.BezmenClientJavaHttp;
import org.smecalculus.bezmen.messaging.spec.BezmenClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class StandBeans {

    @Bean
    BezmenClient bezmenClient() {
        ObjectMapper mapper = new ObjectMapper();
        HttpClient client = HttpClient.newHttpClient();
        return new BezmenClientJavaHttp(mapper, client);
    }
}
