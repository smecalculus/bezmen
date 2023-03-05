package org.smecalculus.bezmen.core.validation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

@Configuration(proxyBeanMethods = false)
public class ValidationBeans {

    @Bean
    Validator validator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        return factory.getValidator();
    }

    @Bean
    BezmenValidator bezmenValidator(Validator validator) {
        return new BezmenValidatorImpl(validator);
    }
}
