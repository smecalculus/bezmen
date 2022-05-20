package org.smecalculus.bezmen.weighing.data.beans;

import org.smecalculus.bezmen.weighing.WeighingModelMapper;
import org.smecalculus.bezmen.weighing.WeighingModelMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class WeighingDaoBeans {

    @Bean
    public WeighingModelMapper mapper() {
        return new WeighingModelMapperImpl();
    }
}
