package org.smecalculus.bezmen.integration.client;

import lombok.NonNull;
import org.smecalculus.bezmen.client.SepulkaRegReq;
import org.smecalculus.bezmen.client.SepulkaRegRes;
import org.smecalculus.bezmen.client.VerboseBezmenClient;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

public record SpringMvcBezmenClient(
        @NonNull WebTestClient client
) implements VerboseBezmenClient {

    @Override
    public SepulkaRegRes register(@NonNull SepulkaRegReq request) {
        return client.post()
                .uri("/sepulkas")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .exchange()
                .expectBody(SepulkaRegRes.class)
                .returnResult()
                .getResponseBody();
    }
}
