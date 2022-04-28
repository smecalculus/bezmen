package org.smecalculus.bezmen.config.data;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = {
        CmMapper.class
})
public class ConfigBeans {

    @Bean
    public DataConfig dataConfig(CmMapper cmMapper) {
        return new DataConfigImpl(cmMapper);
    }
}
