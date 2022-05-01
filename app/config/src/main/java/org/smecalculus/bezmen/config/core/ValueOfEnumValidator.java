package org.smecalculus.bezmen.config.core;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Set;
import java.util.stream.Stream;

import static java.lang.String.format;
import static java.util.stream.Collectors.toSet;

public class ValueOfEnumValidator implements ConstraintValidator<ValueOfEnum, String> {
    private Set<String> allowedValues;

    @Override
    public void initialize(ValueOfEnum constraintAnnotation) {
        allowedValues = Stream.of(constraintAnnotation.value().getEnumConstants())
                .map(Enum::name)
                .collect(toSet());
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        if (!allowedValues.contains(value.toUpperCase())) {
            context.buildConstraintViolationWithTemplate(format("Allowed values: %s", allowedValues))
                    .addConstraintViolation();
            return false;
        }

        return true;
    }
}
