package org.smecalculus.bezmen.web;

import org.smecalculus.bezmen.weighing.WeighingBeans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration(proxyBeanMethods = false)
@Import({
        WeighingBeans.class,
        ServletWebServerFactoryAutoConfiguration.class
})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
