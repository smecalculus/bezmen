package org.smecalculus.bezmen.foo.messaging;

import org.smecalculus.bezmen.foo.messaging.harness.SpringMVCWeighingClient;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.client.MockMvcWebTestClient;

public class WeighingApiSpringMVCTest extends WeighingApiTest {

    @Override
    void setupClient(WeighingApi weighingApi) {
        WebTestClient webTestClient = MockMvcWebTestClient
                .bindToController(new WeighingHttpController(weighingApi))
                .build();
        weighingClient = new SpringMVCWeighingClient(webTestClient);
    }
}
