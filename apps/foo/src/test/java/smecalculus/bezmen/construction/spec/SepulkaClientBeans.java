package smecalculus.bezmen.construction.spec;

import static org.mockito.Mockito.mock;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.client.MockMvcWebTestClient;
import smecalculus.bezmen.domain.impl.SepulkaConverterImpl;
import smecalculus.bezmen.domain.spec.SepulkaConverter;
import smecalculus.bezmen.domain.spec.SepulkaService;
import smecalculus.bezmen.messaging.impl.SepulkaClientImpl;
import smecalculus.bezmen.messaging.impl.SepulkaClientSpringWeb;
import smecalculus.bezmen.messaging.impl.springmvc.SepulkaController;
import smecalculus.bezmen.messaging.spec.SepulkaClient;
import smecalculus.bezmen.messaging.spec.SepulkaMsgMapper;
import smecalculus.bezmen.messaging.spec.SepulkaMsgMapperImpl;
import smecalculus.bezmen.validation.spec.BezmenValidator;

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
