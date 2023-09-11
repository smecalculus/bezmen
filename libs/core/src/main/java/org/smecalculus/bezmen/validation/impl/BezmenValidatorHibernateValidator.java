package org.smecalculus.bezmen.validation.impl;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import java.util.Set;
import lombok.NonNull;
import org.smecalculus.bezmen.validation.spec.BezmenValidator;

public record BezmenValidatorHibernateValidator(@NonNull Validator validator) implements BezmenValidator {

    @Override
    public <T> void validate(T object, Class<?>... groups) {
        Set<ConstraintViolation<T>> violations = validator.validate(object, groups);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }
}