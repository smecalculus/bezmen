package smecalculus.bezmen.messaging;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

@RequiredArgsConstructor
public class SepulkaClientSpringWeb implements SepulkaClient {

    @NonNull
    private WebTestClient client;

    @Override
    public SepulkaNewResponseMsg register(SepulkaNewRequestMsg request) {
        return client.post()
                .uri("/sepulkas")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .exchange()
                .expectBody(SepulkaNewResponseMsg.class)
                .returnResult()
                .getResponseBody();
    }
}
