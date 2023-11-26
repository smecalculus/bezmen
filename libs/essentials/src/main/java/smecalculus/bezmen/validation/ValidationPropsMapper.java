package smecalculus.bezmen.validation;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import smecalculus.bezmen.configuration.ValidationDm;
import smecalculus.bezmen.configuration.ValidationEm;
import smecalculus.bezmen.mapping.EdgeMapper;

@Mapper
public interface ValidationPropsMapper extends EdgeMapper {
    @Mapping(source = "mode", target = "validationMode")
    ValidationDm.ValidationProps toDomain(ValidationEm.ValidationProps props);

    default ValidationDm.ValidationMode toValidationMode(String value) {
        return ValidationDm.ValidationMode.valueOf(value.toUpperCase());
    }
}
