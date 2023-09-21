package smecalculus.bezmen.construction;

import jakarta.validation.Validation;
import jakarta.validation.ValidatorFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import smecalculus.bezmen.validation.EdgeValidator;
import smecalculus.bezmen.validation.EdgeValidatorHibernateValidator;

@Configuration(proxyBeanMethods = false)
public class ValidationBeans {

    @Bean
    EdgeValidator validator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        return new EdgeValidatorHibernateValidator(factory.getValidator());
    }
}
