package smecalculus.bezmen.messaging;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import smecalculus.bezmen.messaging.EdgeSide.RegistrationRequest;
import smecalculus.bezmen.messaging.EdgeSide.RegistrationResponse;

@RequiredArgsConstructor
public class SepulkaClientSpringWebTest implements SepulkaClient {

    @NonNull
    private WebTestClient client;

    @Override
    public RegistrationResponse register(RegistrationRequest request) {
        return client.post()
                .uri("/sepulkas")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .exchange()
                .expectBody(RegistrationResponse.class)
                .returnResult()
                .getResponseBody();
    }
}
