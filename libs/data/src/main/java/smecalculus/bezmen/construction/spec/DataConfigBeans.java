package smecalculus.bezmen.construction.spec;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import smecalculus.bezmen.configuration.impl.DataConfigImpl;
import smecalculus.bezmen.configuration.spec.ConfigKeeper;
import smecalculus.bezmen.configuration.spec.DataCfgMapper;
import smecalculus.bezmen.configuration.spec.DataCfgMapperImpl;
import smecalculus.bezmen.configuration.spec.DataConfig;
import smecalculus.bezmen.configuration.spec.DataProps;
import smecalculus.bezmen.validation.spec.BezmenValidator;

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
