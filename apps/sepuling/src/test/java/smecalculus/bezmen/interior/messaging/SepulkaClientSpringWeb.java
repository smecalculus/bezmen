package smecalculus.bezmen.interior.messaging;

import lombok.NonNull;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import smecalculus.bezmen.exterior.messaging.SepulkaClient;
import smecalculus.bezmen.exterior.messaging.SepulkaMsgMapper;
import smecalculus.bezmen.exterior.messaging.SepulkaRegisterSlice;
import smecalculus.bezmen.exterior.messaging.SepulkaRegisteredSlice;
import smecalculus.bezmen.exterior.messaging.SepulkaRegisteredSliceMsg;

// TODO: подумать о том, чтобы перенести в testing, в messaging или в abstraction (prod or test jar)
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
