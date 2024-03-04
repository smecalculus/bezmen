package smecalculus.bezmen.messaging;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import smecalculus.bezmen.messaging.SepulkaMessageEm.RegistrationRequest;
import smecalculus.bezmen.messaging.SepulkaMessageEm.RegistrationResponse;
import smecalculus.bezmen.messaging.SepulkaMessageEm.ViewRequest;
import smecalculus.bezmen.messaging.SepulkaMessageEm.ViewResponse;

@RequiredArgsConstructor
public class SepulkaClientSpringWebTest implements SepulkaClient {

    @NonNull
    private final WebTestClient client;

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

    @Override
    public ViewResponse view(ViewRequest request) {
        return client.get()
                .uri("/sepulkas/" + request.getExternalId())
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectBody(ViewResponse.class)
                .returnResult()
                .getResponseBody();
    }
}
