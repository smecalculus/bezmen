package org.smecalculus.bezmen.foo;

import com.smecalculus.bezmen.configuration.MessagingProps;
import com.smecalculus.bezmen.messaging.MessagingBeans;
import org.smecalculus.bezmen.client.SepulkaClient;
import org.smecalculus.bezmen.data.DataBeans;
import org.smecalculus.bezmen.data.SepulkaDao;
import org.smecalculus.bezmen.data.SepulkaDaoSpringData;
import org.smecalculus.bezmen.data.SepulkaRecMapper;
import org.smecalculus.bezmen.data.SepulkaRecMapperImpl;
import org.smecalculus.bezmen.data.springdata.SepulkaRepository;
import org.smecalculus.bezmen.messaging.SepulkaClientDefault;
import org.smecalculus.bezmen.messaging.SepulkaMsgMapper;
import org.smecalculus.bezmen.messaging.SepulkaMsgMapperImpl;
import org.smecalculus.bezmen.modeling.SepulkaConverter;
import org.smecalculus.bezmen.modeling.SepulkaService;
import org.smecalculus.bezmen.service.SepulkaConverterDefault;
import org.smecalculus.bezmen.service.SepulkaServiceDefault;
import org.smecalculus.bezmen.service.ServiceBeans;
import org.smecalculus.bezmen.validation.BezmenValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@Configuration(proxyBeanMethods = false)
@Import({MessagingBeans.class, ServiceBeans.class, DataBeans.class})
@ComponentScan(basePackageClasses = {SepulkaClientDefault.class, SepulkaDao.class})
@EnableJdbcRepositories(basePackageClasses = SepulkaDao.class)
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
    public SepulkaDao dao(SepulkaRecMapper mapper,
                          SepulkaRepository repository) {
        return new SepulkaDaoSpringData(mapper, repository);
    }

    @Bean
    SepulkaService service(SepulkaDao sepulkaDao) {
        return new SepulkaServiceDefault(sepulkaDao);
    }

    @Bean
    SepulkaConverter converter() {
        return new SepulkaConverterDefault();
    }

    @Bean
    SepulkaClient client(BezmenValidator validator,
                         SepulkaService service,
                         SepulkaConverter converter) {
        return new SepulkaClientDefault(validator, service, converter);
    }

    @Bean
    FooRegistrar registrar(MessagingProps messagingProps) {
        return new FooRegistrar(messagingProps.receptionProps().protocols());
    }
}
