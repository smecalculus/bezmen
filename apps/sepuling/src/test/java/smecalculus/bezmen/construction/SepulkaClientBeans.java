package smecalculus.bezmen.construction;

import static org.mockito.Mockito.mock;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.client.MockMvcWebTestClient;
import smecalculus.bezmen.core.SepulkaService;
import smecalculus.bezmen.core.SepulkaSliceMapper;
import smecalculus.bezmen.core.SepulkaSliceMapperImpl;
import smecalculus.bezmen.messaging.SepulkaClientImpl;
import smecalculus.bezmen.messaging.SepulkaClientSpringWeb;
import smecalculus.bezmen.messaging.SepulkaMsgMapper;
import smecalculus.bezmen.messaging.SepulkaMsgMapperImpl;
import smecalculus.bezmen.messaging.client.SepulkaClient;
import smecalculus.bezmen.messaging.springmvc.SepulkaController;
import smecalculus.bezmen.validation.EdgeValidator;

@Import(ValidationBeans.class)
@Configuration(proxyBeanMethods = false)
public class SepulkaClientBeans {

    @Bean
    public SepulkaService sepulkaService() {
        return mock(SepulkaService.class);
    }

    @Bean
    SepulkaSliceMapper sepulkaConverter() {
        return new SepulkaSliceMapperImpl();
    }

    @Bean
    SepulkaClient internalClient(SepulkaService service, SepulkaSliceMapper mapper) {
        return new SepulkaClientImpl(service, mapper);
    }

    @Bean
    SepulkaClient externalClient(EdgeValidator validator, SepulkaClient internalClient) {
        SepulkaMsgMapper mapper = new SepulkaMsgMapperImpl();
        WebTestClient client = MockMvcWebTestClient.bindToController(
                        new SepulkaController(validator, internalClient, mapper))
                .build();
        return new SepulkaClientSpringWeb(client, mapper);
    }
}
