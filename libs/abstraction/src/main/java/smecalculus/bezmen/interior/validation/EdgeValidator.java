package smecalculus.bezmen.interior.validation;

public interface EdgeValidator {
    <T> void validate(T object, Class<?>... groups);
}
