package org.smecalculus.bezmen.foo.data.beans;

import org.smecalculus.bezmen.foo.data.SepulkaRecMapper;
import org.smecalculus.bezmen.foo.data.SepulkaRecMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class SepulkaDaoBeans {

    @Bean
    public SepulkaRecMapper mapper() {
        return new SepulkaRecMapperImpl();
    }
}
