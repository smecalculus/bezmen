package org.smecalculus.bezmen.core.validation;

import lombok.NonNull;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.Set;

record BezmenValidatorImpl(
        @NonNull Validator validator
) implements BezmenValidator {

    @Override
    public <T> void validate(T object, Class<?>... groups) {
        Set<ConstraintViolation<T>> violations = validator.validate(object, groups);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }
}
