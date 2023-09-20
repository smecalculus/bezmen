package smecalculus.bezmen.construction.spec;

import jakarta.validation.Validation;
import jakarta.validation.ValidatorFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import smecalculus.bezmen.validation.impl.BezmenValidatorHibernateValidator;
import smecalculus.bezmen.validation.spec.BezmenValidator;

@Configuration(proxyBeanMethods = false)
public class ValidationBeans {

    @Bean
    BezmenValidator validator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        return new BezmenValidatorHibernateValidator(factory.getValidator());
    }
}
