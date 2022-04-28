package org.smecalculus.bezmen.config.data.contract;

import org.smecalculus.bezmen.config.data.impl.CmMapper;
import org.smecalculus.bezmen.config.data.impl.DataConfigImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = CmMapper.class)
public class ConfigBeans {

    @Bean
    public DataConfig dataConfig(CmMapper cmMapper) {
        return new DataConfigImpl(cmMapper);
    }

    @Bean
    public DataProps dataProps(DataConfig dataConfig) {
        return dataConfig.getDataProps();
    }
}
