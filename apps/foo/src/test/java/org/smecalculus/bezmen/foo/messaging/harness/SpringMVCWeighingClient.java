package org.smecalculus.bezmen.foo.messaging.harness;

import lombok.NonNull;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.EntityExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;

public record SpringMVCWeighingClient(
        @NonNull WebTestClient client
) implements WeighingClient {

    @Override
    public <P, Q> WeighingResponse<Q> send(@NonNull WeighingRequest<P, Q> request) {
        EntityExchangeResult<Q> result = client.post()
                .uri("/weighings")
                .contentType(MediaType.APPLICATION_JSON)
                .headers(headers -> headers.setAll(request.metadata()))
                .bodyValue(request.body())
                .exchange()
                .expectBody(request.responseType())
                .returnResult();

        return WeighingResponse.<Q>builder()
                .metadata(result.getResponseHeaders().toSingleValueMap())
                .body(result.getResponseBody())
                .build();
    }
}
