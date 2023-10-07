package smecalculus.bezmen;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.http.HttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import smecalculus.bezmen.exterior.messaging.BezmenClient;
import smecalculus.bezmen.exterior.messaging.BezmenClientJavaHttp;
import smecalculus.bezmen.exterior.messaging.SepulkaMsgMapper;
import smecalculus.bezmen.exterior.messaging.SepulkaMsgMapperImpl;

@Configuration(proxyBeanMethods = false)
public class StandBeans {

    @Bean
    BezmenClient bezmenClient() {
        SepulkaMsgMapper msgMapper = new SepulkaMsgMapperImpl();
        ObjectMapper jsonMapper = new ObjectMapper();
        HttpClient client = HttpClient.newHttpClient();
        return new BezmenClientJavaHttp(msgMapper, jsonMapper, client);
    }
}
