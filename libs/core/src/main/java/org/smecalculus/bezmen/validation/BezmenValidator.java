package org.smecalculus.bezmen.validation;

public interface BezmenValidator {
    <T> void validate(T object, Class<?>... groups);
}
