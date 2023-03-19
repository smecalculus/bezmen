package org.smecalculus.bezmen.core.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import lombok.NonNull;

import java.util.Set;

record BezmenValidatorHibernateValidator(
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
