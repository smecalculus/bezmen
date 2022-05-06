package org.smecalculus.bezmen.weighing;

import com.smecalculus.bezmen.messaging.MessagingBeans;
import com.smecalculus.bezmen.messaging.config.MessagingProps;
import org.smecalculus.bezmen.core.validation.BezmenValidator;
import org.smecalculus.bezmen.data.DataBeans;
import org.smecalculus.bezmen.weighing.data.WeighingDao;
import org.smecalculus.bezmen.weighing.data.WeighingDaoImpl;
import org.smecalculus.bezmen.weighing.data.WeighingDmMapper;
import org.smecalculus.bezmen.weighing.data.WeighingRepository;
import org.smecalculus.bezmen.weighing.messaging.DefaultMessagingApi;
import org.smecalculus.bezmen.weighing.messaging.WeighingApi;
import org.smecalculus.bezmen.weighing.messaging.WeighingRmMapper;
import org.smecalculus.bezmen.weighing.service.WeighingService;
import org.smecalculus.bezmen.weighing.service.WeighingServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@Configuration(proxyBeanMethods = false)
@Import({MessagingBeans.class, DataBeans.class})
@ComponentScan(basePackageClasses = {WeighingRmMapper.class, WeighingDmMapper.class})
@EnableJdbcRepositories(basePackages = "org.smecalculus.bezmen.weighing.data")
public class WeighingBeans {

    @Bean
    public WeighingDao weighingDao(WeighingDmMapper mapper, WeighingRepository repository) {
        return new WeighingDaoImpl(mapper, repository);
    }

    @Bean
    WeighingService weighingService(WeighingDao weighingDao) {
        return new WeighingServiceImpl(weighingDao);
    }

    @Bean
    WeighingApi messagingApi(WeighingService service,
                             WeighingRmMapper mapper,
                             BezmenValidator validator) {
        return new DefaultMessagingApi(service, mapper, validator);
    }

    @Bean
    ControllerRegistrar controllerRegistrar(MessagingProps messagingProps) {
        return new ControllerRegistrar(messagingProps.receptionProps().protocols());
    }
}
