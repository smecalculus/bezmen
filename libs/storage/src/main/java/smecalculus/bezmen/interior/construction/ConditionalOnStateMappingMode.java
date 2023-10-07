package smecalculus.bezmen.interior.construction;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.context.annotation.Conditional;
import smecalculus.bezmen.interior.configuration.StateMappingMode;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Conditional(StateMappingModeCondition.class)
public @interface ConditionalOnStateMappingMode {
    StateMappingMode value();
}
