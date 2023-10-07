package smecalculus.bezmen.messaging;

import lombok.NonNull;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import smecalculus.bezmen.messaging.client.SepulkaClient;
import smecalculus.bezmen.messaging.client.SepulkaRegisterSlice;
import smecalculus.bezmen.messaging.client.SepulkaRegisteredSlice;

public record SepulkaClientSpringWeb(@NonNull WebTestClient client, @NonNull SepulkaMsgMapper mapper)
        implements SepulkaClient {

    @Override
    public SepulkaRegisteredSlice register(SepulkaRegisterSlice command) {
        SepulkaRegisteredSliceMsg response = client.post()
                .uri("/sepulkas")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .bodyValue(mapper.toMsg(command))
                .exchange()
                .expectBody(SepulkaRegisteredSliceMsg.class)
                .returnResult()
                .getResponseBody();
        return mapper.toDomain(response);
    }
}
