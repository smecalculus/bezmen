package org.smecalculus.bezmen.configuration;

import org.smecalculus.bezmen.core.CoreBeans;
import org.smecalculus.bezmen.validation.BezmenValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration(proxyBeanMethods = false)
@Import({CoreBeans.class})
public class DataConfigBeans {

    @Bean
    DataMapper dataMapper() {
        return new DataMapperImpl();
    }

    @Bean
    DataConfig dataConfig(ConfigKeeper keeper, BezmenValidator validator, DataMapper mapper) {
        return new DataConfigImpl(keeper, validator, mapper);
    }
}
