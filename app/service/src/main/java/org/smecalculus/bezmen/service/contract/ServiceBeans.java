package org.smecalculus.bezmen.service.contract;

import org.smecalculus.bezmen.data.contract.DataBeans;
import org.smecalculus.bezmen.data.contract.WeighingDao;
import org.smecalculus.bezmen.service.impl.WeighingServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(DataBeans.class)
public class ServiceBeans {

    @Bean
    public WeighingService weighingService(WeighingDao weighingDao) {
        return new WeighingServiceImpl(weighingDao);
    }
}
