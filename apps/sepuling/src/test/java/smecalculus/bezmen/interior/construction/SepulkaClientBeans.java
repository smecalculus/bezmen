package smecalculus.bezmen.interior.construction;

import static org.mockito.Mockito.mock;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.client.MockMvcWebTestClient;
import smecalculus.bezmen.exterior.messaging.SepulkaClient;
import smecalculus.bezmen.exterior.messaging.SepulkaMsgMapper;
import smecalculus.bezmen.exterior.messaging.SepulkaMsgMapperImpl;
import smecalculus.bezmen.interior.core.SepulkaService;
import smecalculus.bezmen.interior.core.SepulkaSliceMapper;
import smecalculus.bezmen.interior.core.SepulkaSliceMapperImpl;
import smecalculus.bezmen.interior.messaging.SepulkaClientImpl;
import smecalculus.bezmen.interior.messaging.SepulkaClientSpringWeb;
import smecalculus.bezmen.interior.messaging.springmvc.SepulkaController;
import smecalculus.bezmen.interior.validation.EdgeValidator;

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
