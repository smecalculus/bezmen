package org.smecalculus.bezmen.config.data.contract;

import com.typesafe.config.Config;
import org.smecalculus.bezmen.config.data.impl.CmMapper;
import org.smecalculus.bezmen.config.data.impl.DataConfigImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validator;

@Configuration
@ComponentScan(basePackageClasses = CmMapper.class)
public class ConfigBeans {

    @Bean
    public BezmenValidator validator(Validator validator) {
        return new BezmenValidator(validator);
    }

    @Bean
    public DataConfig dataConfig(Config config, BezmenValidator validator, CmMapper cmMapper) {
        return new DataConfigImpl(config, validator, cmMapper);
    }

    @Bean
    public DataProps dataProps(DataConfig dataConfig) {
        return dataConfig.getDataProps();
    }
}
