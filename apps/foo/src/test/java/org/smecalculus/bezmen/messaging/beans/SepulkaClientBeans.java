package org.smecalculus.bezmen.messaging.beans;

import org.smecalculus.bezmen.client.SepulkaClient;
import org.smecalculus.bezmen.messaging.SepulkaClientImpl;
import org.smecalculus.bezmen.messaging.SepulkaClientSpringWeb;
import org.smecalculus.bezmen.messaging.SepulkaMsgMapper;
import org.smecalculus.bezmen.messaging.SepulkaMsgMapperImpl;
import org.smecalculus.bezmen.messaging.springweb.SepulkaController;
import org.smecalculus.bezmen.service.SepulkaConverter;
import org.smecalculus.bezmen.service.SepulkaService;
import org.smecalculus.bezmen.validation.BezmenValidator;
import org.smecalculus.bezmen.validation.ValidationBeans;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.client.MockMvcWebTestClient;

import static org.mockito.Mockito.mock;

@Configuration(proxyBeanMethods = false)
@Import({ValidationBeans.class})
public class SepulkaClientBeans {

    @Bean
    public SepulkaService service() {
        return mock(SepulkaService.class);
    }

    @Bean
    SepulkaConverter converter() {
        return new SepulkaConverter();
    }

    @Bean
    SepulkaClient internalClient(BezmenValidator validator,
                         SepulkaService service,
                         SepulkaConverter converter) {
        return new SepulkaClientImpl(validator, service, converter);
    }

    @Bean
    SepulkaClient externalClient(SepulkaClient internalClient) {
        SepulkaMsgMapper mapper = new SepulkaMsgMapperImpl();
        WebTestClient client = MockMvcWebTestClient
                .bindToController(new SepulkaController(internalClient, mapper))
                .build();
        return new SepulkaClientSpringWeb(client, mapper);
    }
}
