package org.smecalculus.bezmen.construction;

import org.smecalculus.bezmen.configuration.WebMode;
import org.springframework.context.annotation.Conditional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Conditional(WebModeCondition.class)
public @interface ConditionalOnWebMode {
    WebMode value();
}
