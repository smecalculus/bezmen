package org.smecalculus.bezmen.foo;

import com.smecalculus.bezmen.messaging.MessagingBeans;
import com.smecalculus.bezmen.messaging.model.MessagingProps;
import org.smecalculus.bezmen.client.SepulkaClient;
import org.smecalculus.bezmen.data.DataBeans;
import org.smecalculus.bezmen.data.SepulkaDao;
import org.smecalculus.bezmen.data.SepulkaDaoSpringData;
import org.smecalculus.bezmen.data.SepulkaRecMapper;
import org.smecalculus.bezmen.data.springdata.SepulkaRepository;
import org.smecalculus.bezmen.messaging.SepulkaClientImpl;
import org.smecalculus.bezmen.service.SepulkaConverter;
import org.smecalculus.bezmen.service.SepulkaService;
import org.smecalculus.bezmen.service.SepulkaServiceImpl;
import org.smecalculus.bezmen.service.ServiceBeans;
import org.smecalculus.bezmen.validation.BezmenValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@Configuration(proxyBeanMethods = false)
@Import({MessagingBeans.class, ServiceBeans.class, DataBeans.class})
@ComponentScan(basePackageClasses = {SepulkaRecMapper.class})
@EnableJdbcRepositories(basePackages = "org.smecalculus.bezmen.foo.data")
public class SepulkaBeans {

    @Bean
    public SepulkaDao dao(SepulkaRecMapper mapper,
                          SepulkaRepository repository) {
        return new SepulkaDaoSpringData(mapper, repository);
    }

    @Bean
    SepulkaService service(SepulkaDao sepulkaDao) {
        return new SepulkaServiceImpl(sepulkaDao);
    }

    @Bean
    SepulkaConverter converter() {
        return new SepulkaConverter();
    }

    @Bean
    SepulkaClient client(BezmenValidator validator,
                         SepulkaService service,
                         SepulkaConverter converter) {
        return new SepulkaClientImpl(validator, service, converter);
    }

    @Bean
    WeighingRegistrar controllerRegistrar(MessagingProps messagingProps) {
        return new WeighingRegistrar(messagingProps.receptionProps().protocols());
    }
}
