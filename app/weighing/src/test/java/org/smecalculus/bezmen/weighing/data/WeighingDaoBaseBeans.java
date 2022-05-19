package org.smecalculus.bezmen.weighing.data;

import org.smecalculus.bezmen.weighing.WeighingMapper;
import org.smecalculus.bezmen.weighing.WeighingMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class WeighingDaoBaseBeans {

    @Bean
    public WeighingMapper mapper() {
        return new WeighingMapperImpl();
    }
}
