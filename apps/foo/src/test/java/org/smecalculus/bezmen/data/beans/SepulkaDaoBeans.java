package org.smecalculus.bezmen.data.beans;

import org.smecalculus.bezmen.data.SepulkaRecMapper;
import org.smecalculus.bezmen.data.SepulkaRecMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class SepulkaDaoBeans {

    @Bean
    public SepulkaRecMapper mapper() {
        return new SepulkaRecMapperImpl();
    }
}
