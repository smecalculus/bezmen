package smecalculus.bezmen.interior.construction;

import jakarta.validation.Validation;
import jakarta.validation.ValidatorFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import smecalculus.bezmen.interior.validation.EdgeValidator;
import smecalculus.bezmen.interior.validation.EdgeValidatorHibernateValidator;

@Configuration(proxyBeanMethods = false)
public class ValidationBeans {

    @Bean
    EdgeValidator edgeValidatorHibernateValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        return new EdgeValidatorHibernateValidator(factory.getValidator());
    }
}
