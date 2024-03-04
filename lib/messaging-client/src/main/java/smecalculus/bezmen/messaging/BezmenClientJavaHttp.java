package smecalculus.bezmen.messaging;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import smecalculus.bezmen.configuration.ClientProps;
import smecalculus.bezmen.messaging.SepulkaMessageEm.RegistrationRequest;
import smecalculus.bezmen.messaging.SepulkaMessageEm.RegistrationResponse;
import smecalculus.bezmen.messaging.SepulkaMessageEm.ViewRequest;
import smecalculus.bezmen.messaging.SepulkaMessageEm.ViewResponse;

@RequiredArgsConstructor
public class BezmenClientJavaHttp implements BezmenClient {

    @NonNull
    private ClientProps props;

    @NonNull
    private ObjectMapper mapper;

    @NonNull
    private HttpClient client;

    @Override
    public RegistrationResponse register(RegistrationRequest request) {
        URI uri = URI.create("http://" + props.host() + ":" + props.port() + "/sepulkas");
        try {
            var requestJson = mapper.writeValueAsString(request);
            var httpRequest = HttpRequest.newBuilder()
                    .uri(uri)
                    .POST(BodyPublishers.ofString(requestJson))
                    .header("Content-Type", "application/json")
                    .header("Accept", "application/json")
                    .build();
            var httpResponse = client.send(httpRequest, BodyHandlers.ofString());
            if (httpResponse.statusCode() < 300) {
                return mapper.readValue(httpResponse.body(), RegistrationResponse.class);
            }
            throw new RuntimeException(httpResponse.body());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ViewResponse view(ViewRequest request) {
        URI uri = URI.create("http://" + props.host() + ":" + props.port() + "/sepulkas/" + request.getExternalId());
        try {
            var httpRequest = HttpRequest.newBuilder()
                    .uri(uri)
                    .GET()
                    .header("Accept", "application/json")
                    .build();
            var httpResponse = client.send(httpRequest, BodyHandlers.ofString());
            if (httpResponse.statusCode() < 300) {
                return mapper.readValue(httpResponse.body(), ViewResponse.class);
            }
            throw new RuntimeException(httpResponse.body());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean isReady() {
        URI uri = URI.create("http://" + props.host() + ":" + props.port() + "/actuator/health");
        try {
            var httpRequest = HttpRequest.newBuilder().uri(uri).GET().build();
            var httpResponse = client.send(httpRequest, BodyHandlers.discarding());
            return httpResponse.statusCode() == 200;
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
