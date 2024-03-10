package smecalculus.bezmen.construction;

import static com.fasterxml.jackson.core.JsonParser.Feature.INCLUDE_SOURCE_IN_LOCATION;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientImpl;
import com.github.dockerjava.httpclient5.ApacheDockerHttpClient;
import java.net.http.HttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import smecalculus.bezmen.configuration.ClientProps;
import smecalculus.bezmen.configuration.TestingProps;
import smecalculus.bezmen.messaging.BezmenClient;
import smecalculus.bezmen.messaging.BezmenClientJavaHttp;
import smecalculus.bezmen.testing.Demiurge;

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
        jsonMapper.enable(INCLUDE_SOURCE_IN_LOCATION);
        var httpClient = HttpClient.newHttpClient();
        return new BezmenClientJavaHttp(clientProps, jsonMapper, httpClient);
    }

    @Bean
    DockerClient dockerClient() {
        var clientConfig =
                DefaultDockerClientConfig.createDefaultConfigBuilder().build();
        var httpClient = new ApacheDockerHttpClient.Builder()
                .dockerHost(clientConfig.getDockerHost())
                .build();
        return DockerClientImpl.getInstance(clientConfig, httpClient);
    }

    @Bean
    Demiurge demiurge(DockerClient dockerClient) {
        return new Demiurge(dockerClient);
    }
}
