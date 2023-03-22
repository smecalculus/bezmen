package org.smecalculus.bezmen.foo.messaging;

import org.smecalculus.bezmen.client.SepulkaClient;
import org.smecalculus.bezmen.foo.messaging.springweb.SepulkaController;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.client.MockMvcWebTestClient;

public class SepulkaClientSpringWebIT extends SepulkaClientIT {

    @Override
    void setupClient(SepulkaClient sepulkaClient) {
        SepulkaMsgMapper mapper = new SepulkaMsgMapperImpl();
        WebTestClient client = MockMvcWebTestClient
                .bindToController(new SepulkaController(sepulkaClient, mapper))
                .build();
        webClient = new SepulkaClientSpringWeb(client, mapper);
    }
}
