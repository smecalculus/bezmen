package smecalculus.bezmen.validation;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import smecalculus.bezmen.configuration.ValidationDm;
import smecalculus.bezmen.configuration.ValidationDm.ValidationMode;
import smecalculus.bezmen.configuration.ValidationEm;

@Mapper
public interface ValidationPropsMapper {
    @Mapping(source = "mode", target = "validationMode")
    ValidationDm.ValidationProps toDomain(ValidationEm.ValidationProps props);

    default ValidationMode toValidationMode(String value) {
        return ValidationMode.valueOf(value.toUpperCase());
    }
}
