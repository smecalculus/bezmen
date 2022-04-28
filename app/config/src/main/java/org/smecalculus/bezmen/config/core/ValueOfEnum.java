package org.smecalculus.bezmen.config.core;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = ValueOfEnumValidator.class)
@Target({ FIELD })
@Retention(RUNTIME)
public @interface ValueOfEnum {

    String message() default "foo bar";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    Class<? extends Enum<?>> value();

}