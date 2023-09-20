package smecalculus.bezmen.messaging.impl;

import lombok.NonNull;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import smecalculus.bezmen.messaging.spec.SepulkaClient;
import smecalculus.bezmen.messaging.spec.SepulkaMsgMapper;
import smecalculus.bezmen.messaging.spec.SepulkaRegReq;
import smecalculus.bezmen.messaging.spec.SepulkaRegRes;
import smecalculus.bezmen.messaging.spec.SepulkaRegResMsg;

public record SepulkaClientSpringWeb(@NonNull WebTestClient client, @NonNull SepulkaMsgMapper mapper)
        implements SepulkaClient {

    @Override
    public SepulkaRegRes register(SepulkaRegReq request) {
        SepulkaRegResMsg response = client.post()
                .uri("/sepulkas")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .bodyValue(mapper.toMsg(request))
                .exchange()
                .expectBody(SepulkaRegResMsg.class)
                .returnResult()
                .getResponseBody();
        return mapper.toDomain(response);
    }
}
