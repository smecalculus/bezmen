package smecalculus.bezmen.interior.construction;

import static org.mockito.Mockito.mock;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.client.MockMvcWebTestClient;
import smecalculus.bezmen.exterior.messaging.SepulkaClient;
import smecalculus.bezmen.exterior.messaging.SepulkaMsgMapperImpl;
import smecalculus.bezmen.interior.core.SepulkaService;
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
    SepulkaClient internalClient(EdgeValidator validator, SepulkaService service) {
        var mapper = new SepulkaMsgMapperImpl();
        return new SepulkaClientImpl(validator, mapper, service);
    }

    @Bean
    SepulkaClient externalClient(SepulkaClient internalClient) {
        var client = MockMvcWebTestClient.bindToController(new SepulkaController(internalClient))
                .build();
        return new SepulkaClientSpringWeb(client);
    }
}
