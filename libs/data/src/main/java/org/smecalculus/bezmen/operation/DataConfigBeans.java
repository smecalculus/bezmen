package org.smecalculus.bezmen.operation;

import org.smecalculus.bezmen.configuration.ConfigKeeper;
import org.smecalculus.bezmen.configuration.DataCfgMapper;
import org.smecalculus.bezmen.configuration.DataCfgMapperImpl;
import org.smecalculus.bezmen.configuration.DataConfigImpl;
import org.smecalculus.bezmen.modeling.DataConfig;
import org.smecalculus.bezmen.validation.BezmenValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class DataConfigBeans {

    @Bean
    DataCfgMapper dataCfgMapper() {
        return new DataCfgMapperImpl();
    }

    @Bean
    DataConfig dataConfig(ConfigKeeper keeper, BezmenValidator validator, DataCfgMapper mapper) {
        return new DataConfigImpl(keeper, validator, mapper);
    }
}
