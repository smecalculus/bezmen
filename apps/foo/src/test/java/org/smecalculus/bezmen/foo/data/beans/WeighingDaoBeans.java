package org.smecalculus.bezmen.foo.data.beans;

import org.smecalculus.bezmen.foo.WeighingModelMapper;
import org.smecalculus.bezmen.foo.WeighingModelMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class WeighingDaoBeans {

    @Bean
    public WeighingModelMapper mapper() {
        return new WeighingModelMapperImpl();
    }
}
