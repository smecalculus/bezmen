package org.smecalculus.bezmen;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.smecalculus.bezmen.client.BezmenClient;
import org.smecalculus.bezmen.client.BezmenClientJavaHttp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.http.HttpClient;

@Configuration(proxyBeanMethods = false)
public class StandBeans {

    @Bean
    BezmenClient client() {
        ObjectMapper mapper = new ObjectMapper();
        HttpClient client = HttpClient.newHttpClient();
        return new BezmenClientJavaHttp(mapper, client);
    }
}