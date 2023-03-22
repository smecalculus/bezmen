package org.smecalculus.bezmen.validation;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class ValidationBeans {

    @Bean
    Validator validator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        return factory.getValidator();
    }

    @Bean
    BezmenValidator bezmenValidator(Validator validator) {
        return new BezmenValidatorHibernateValidator(validator);
    }
}
