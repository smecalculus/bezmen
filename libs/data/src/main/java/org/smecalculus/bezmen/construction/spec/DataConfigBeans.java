package org.smecalculus.bezmen.construction.spec;

import org.smecalculus.bezmen.configuration.impl.DataConfigImpl;
import org.smecalculus.bezmen.configuration.spec.ConfigKeeper;
import org.smecalculus.bezmen.configuration.spec.DataCfgMapper;
import org.smecalculus.bezmen.configuration.spec.DataCfgMapperImpl;
import org.smecalculus.bezmen.configuration.spec.DataConfig;
import org.smecalculus.bezmen.configuration.spec.DataProps;
import org.smecalculus.bezmen.validation.spec.BezmenValidator;
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

    @Bean
    DataProps dataProps(DataConfig config) {
        return config.getDataProps();
    }
}
