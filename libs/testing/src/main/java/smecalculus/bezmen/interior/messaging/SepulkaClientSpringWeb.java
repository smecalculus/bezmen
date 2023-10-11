package smecalculus.bezmen.interior.messaging;

import lombok.NonNull;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import smecalculus.bezmen.exterior.messaging.SepulkaClient;
import smecalculus.bezmen.exterior.messaging.SepulkaRegisterSliceMsg;
import smecalculus.bezmen.exterior.messaging.SepulkaRegisteredSliceMsg;

public record SepulkaClientSpringWeb(@NonNull WebTestClient client) implements SepulkaClient {

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
