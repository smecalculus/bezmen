package smecalculus.bezmen.interior.messaging;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import smecalculus.bezmen.exterior.messaging.SepulkaClient;
import smecalculus.bezmen.exterior.messaging.SepulkaRegisterSliceMsg;
import smecalculus.bezmen.exterior.messaging.SepulkaRegisteredSliceMsg;

@RequiredArgsConstructor
public class SepulkaClientSpringWeb implements SepulkaClient {

    @NonNull
    private WebTestClient client;

    @Override
    public SepulkaRegisteredSliceMsg register(SepulkaRegisterSliceMsg request) {
        return client.post()
                .uri("/sepulkas")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .exchange()
                .expectBody(SepulkaRegisteredSliceMsg.class)
                .returnResult()
                .getResponseBody();
    }
}
