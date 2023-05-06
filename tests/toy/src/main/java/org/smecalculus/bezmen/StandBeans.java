package org.smecalculus.bezmen;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.smecalculus.bezmen.messaging.BezmenClient;
import org.smecalculus.bezmen.messaging.BezmenClientJavaHttp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.http.HttpClient;

@Configuration(proxyBeanMethods = false)
public class StandBeans {

    @Bean
    BezmenClient bezmenClient() {
        ObjectMapper mapper = new ObjectMapper();
        HttpClient client = HttpClient.newHttpClient();
        return new BezmenClientJavaHttp(mapper, client);
    }
}
