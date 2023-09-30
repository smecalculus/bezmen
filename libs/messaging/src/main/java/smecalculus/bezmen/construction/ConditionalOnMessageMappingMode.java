package smecalculus.bezmen.construction;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.context.annotation.Conditional;
import smecalculus.bezmen.configuration.MessageMappingMode;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Conditional(MessageMappingModeCondition.class)
public @interface ConditionalOnMessageMappingMode {
    MessageMappingMode value();
}
