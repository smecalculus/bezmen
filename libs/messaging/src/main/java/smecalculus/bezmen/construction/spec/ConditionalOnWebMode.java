package smecalculus.bezmen.construction.spec;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.context.annotation.Conditional;
import smecalculus.bezmen.configuration.spec.WebMode;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Conditional(WebModeCondition.class)
public @interface ConditionalOnWebMode {
    WebMode value();
}
