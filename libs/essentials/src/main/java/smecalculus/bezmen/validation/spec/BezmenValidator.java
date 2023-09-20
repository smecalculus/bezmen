package smecalculus.bezmen.validation.spec;

public interface BezmenValidator {
    <T> void validate(T object, Class<?>... groups);
}
