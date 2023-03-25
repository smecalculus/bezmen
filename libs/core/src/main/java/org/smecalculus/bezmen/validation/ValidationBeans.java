package org.smecalculus.bezmen.validation;

import jakarta.validation.Validation;
import jakarta.validation.ValidatorFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class ValidationBeans {

    @Bean
    BezmenValidator validator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        return new BezmenValidatorHibernateValidator(factory.getValidator());
    }
}
