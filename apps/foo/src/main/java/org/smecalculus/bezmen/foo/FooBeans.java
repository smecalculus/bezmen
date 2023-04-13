package org.smecalculus.bezmen.foo;

import com.smecalculus.bezmen.configuration.MessagingProps;
import com.smecalculus.bezmen.messaging.MessagingBeans;
import org.smecalculus.bezmen.client.SepulkaClient;
import org.smecalculus.bezmen.construction.DataBeans;
import org.smecalculus.bezmen.data.SepulkaDao;
import org.smecalculus.bezmen.data.SepulkaDaoSpringData;
import org.smecalculus.bezmen.data.SepulkaRecMapper;
import org.smecalculus.bezmen.data.SepulkaRecMapperImpl;
import org.smecalculus.bezmen.data.springdata.SepulkaRepository;
import org.smecalculus.bezmen.messaging.SepulkaClientImpl;
import org.smecalculus.bezmen.messaging.SepulkaMsgMapper;
import org.smecalculus.bezmen.messaging.SepulkaMsgMapperImpl;
import org.smecalculus.bezmen.modeling.SepulkaConverter;
import org.smecalculus.bezmen.modeling.SepulkaService;
import org.smecalculus.bezmen.service.SepulkaConverterImpl;
import org.smecalculus.bezmen.service.SepulkaServiceImpl;
import org.smecalculus.bezmen.service.ServiceBeans;
import org.smecalculus.bezmen.validation.BezmenValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration(proxyBeanMethods = false)
@Import({MessagingBeans.class, ServiceBeans.class, DataBeans.class})
@ComponentScan(basePackageClasses = {SepulkaClientImpl.class})
public class FooBeans {

    @Bean
    public SepulkaRecMapper recMapper() {
        return new SepulkaRecMapperImpl();
    }

    @Bean
    public SepulkaMsgMapper msgMapper() {
        return new SepulkaMsgMapperImpl();
    }

    @Bean
    public SepulkaDao sepulkaDao(SepulkaRecMapper mapper,
                          SepulkaRepository repository) {
        return new SepulkaDaoSpringData(mapper, repository);
    }

    @Bean
    SepulkaService sepulkaService(SepulkaDao sepulkaDao) {
        return new SepulkaServiceImpl(sepulkaDao);
    }

    @Bean
    SepulkaConverter sepulkaConverter() {
        return new SepulkaConverterImpl();
    }

    @Bean
    SepulkaClient sepulkaClient(BezmenValidator validator,
                         SepulkaService service,
                         SepulkaConverter converter) {
        return new SepulkaClientImpl(validator, service, converter);
    }

    @Bean
    FooRegistrar registrar(MessagingProps messagingProps) {
        return new FooRegistrar(messagingProps.receptionProps().protocols());
    }
}
