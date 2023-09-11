package org.smecalculus.bezmen.construction.spec;

import static org.mockito.Mockito.mock;

import org.smecalculus.bezmen.messaging.impl.SepulkaClientImpl;
import org.smecalculus.bezmen.messaging.impl.SepulkaClientSpringWeb;
import org.smecalculus.bezmen.messaging.impl.springmvc.SepulkaController;
import org.smecalculus.bezmen.messaging.spec.SepulkaClient;
import org.smecalculus.bezmen.messaging.spec.SepulkaMsgMapper;
import org.smecalculus.bezmen.messaging.spec.SepulkaMsgMapperImpl;
import org.smecalculus.bezmen.service.impl.SepulkaConverterImpl;
import org.smecalculus.bezmen.service.spec.SepulkaConverter;
import org.smecalculus.bezmen.service.spec.SepulkaService;
import org.smecalculus.bezmen.validation.spec.BezmenValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.client.MockMvcWebTestClient;

@Import(ValidationBeans.class)
@Configuration(proxyBeanMethods = false)
public class SepulkaClientBeans {

    @Bean
    public SepulkaService sepulkaService() {
        return mock(SepulkaService.class);
    }

    @Bean
    SepulkaConverter sepulkaConverter() {
        return new SepulkaConverterImpl();
    }

    @Bean
    SepulkaClient internalClient(BezmenValidator validator, SepulkaService service, SepulkaConverterImpl converter) {
        return new SepulkaClientImpl(validator, service, converter);
    }

    @Bean
    SepulkaClient externalClient(SepulkaClient internalClient) {
        SepulkaMsgMapper mapper = new SepulkaMsgMapperImpl();
        WebTestClient client = MockMvcWebTestClient.bindToController(new SepulkaController(internalClient, mapper))
                .build();
        return new SepulkaClientSpringWeb(client, mapper);
    }
}
