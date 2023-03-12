package org.smecalculus.bezmen.foo;

import com.smecalculus.bezmen.messaging.MessagingBeans;
import com.smecalculus.bezmen.messaging.model.MessagingProps;
import org.smecalculus.bezmen.core.validation.BezmenValidator;
import org.smecalculus.bezmen.data.DataBeans;
import org.smecalculus.bezmen.foo.data.WeighingDao;
import org.smecalculus.bezmen.foo.data.WeighingDaoSpringDataImpl;
import org.smecalculus.bezmen.foo.data.springdata.WeighingRepository;
import org.smecalculus.bezmen.foo.messaging.WeighingApi;
import org.smecalculus.bezmen.foo.messaging.WeighingApiImpl;
import org.smecalculus.bezmen.foo.service.WeighingService;
import org.smecalculus.bezmen.foo.service.WeighingServiceImpl;
import org.smecalculus.bezmen.service.ServiceBeans;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@Configuration(proxyBeanMethods = false)
@Import({MessagingBeans.class, ServiceBeans.class, DataBeans.class})
@ComponentScan(basePackageClasses = {WeighingModelMapper.class})
@EnableJdbcRepositories(basePackages = "org.smecalculus.bezmen.foo.data")
public class WeighingBeans {

    @Bean
    public WeighingDao weighingDao(WeighingModelMapper mapper, WeighingRepository repository) {
        return new WeighingDaoSpringDataImpl(mapper, repository);
    }

    @Bean
    WeighingService weighingService(WeighingDao weighingDao) {
        return new WeighingServiceImpl(weighingDao);
    }

    @Bean
    WeighingApi messagingApi(WeighingService service,
                             WeighingModelMapper mapper,
                             BezmenValidator validator) {
        return new WeighingApiImpl(service, mapper, validator);
    }

    @Bean
    WeighingRegistrar controllerRegistrar(MessagingProps messagingProps) {
        return new WeighingRegistrar(messagingProps.receptionProps().protocols());
    }
}
