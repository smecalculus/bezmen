package org.smecalculus.bezmen.core.validation;

public interface BezmenValidator {
    <T> void validate(T object, Class<?>... groups);
}
