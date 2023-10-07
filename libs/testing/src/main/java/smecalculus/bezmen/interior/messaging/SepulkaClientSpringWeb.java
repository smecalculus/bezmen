package smecalculus.bezmen.interior.messaging;

import lombok.NonNull;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import smecalculus.bezmen.exterior.messaging.SepulkaClient;
import smecalculus.bezmen.exterior.messaging.SepulkaMsgMapper;
import smecalculus.bezmen.exterior.messaging.SepulkaRegisterSlice;
import smecalculus.bezmen.exterior.messaging.SepulkaRegisteredSlice;
import smecalculus.bezmen.exterior.messaging.SepulkaRegisteredSliceMsg;

public record SepulkaClientSpringWeb(@NonNull WebTestClient client, @NonNull SepulkaMsgMapper mapper)
        implements SepulkaClient {

    @Override
    public SepulkaRegisteredSlice register(SepulkaRegisterSlice request) {
        SepulkaRegisteredSliceMsg responseMsg = client.post()
                .uri("/sepulkas")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .bodyValue(mapper.toMsg(request))
                .exchange()
                .expectBody(SepulkaRegisteredSliceMsg.class)
                .returnResult()
                .getResponseBody();
        return mapper.toDomain(responseMsg);
    }
}
