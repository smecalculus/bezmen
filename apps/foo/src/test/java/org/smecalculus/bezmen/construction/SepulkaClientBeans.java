package org.smecalculus.bezmen.construction;

import static org.mockito.Mockito.mock;

import org.smecalculus.bezmen.messaging.SepulkaClient;
import org.smecalculus.bezmen.messaging.SepulkaClientImpl;
import org.smecalculus.bezmen.messaging.SepulkaClientSpringWeb;
import org.smecalculus.bezmen.messaging.SepulkaMsgMapper;
import org.smecalculus.bezmen.messaging.SepulkaMsgMapperImpl;
import org.smecalculus.bezmen.messaging.springmvc.SepulkaController;
import org.smecalculus.bezmen.modeling.SepulkaConverter;
import org.smecalculus.bezmen.modeling.SepulkaService;
import org.smecalculus.bezmen.service.SepulkaConverterImpl;
import org.smecalculus.bezmen.validation.BezmenValidator;
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
