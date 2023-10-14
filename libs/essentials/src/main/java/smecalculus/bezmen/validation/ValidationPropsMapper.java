package smecalculus.bezmen.validation;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import smecalculus.bezmen.configuration.ValidationMode;
import smecalculus.bezmen.configuration.ValidationProps;
import smecalculus.bezmen.configuration.ValidationPropsEdge;

@Mapper
public interface ValidationPropsMapper {
    @Mapping(source = "mode", target = "validationMode")
    ValidationProps toDomain(ValidationPropsEdge propsEdge);

    default ValidationMode toValidationMode(String value) {
        return ValidationMode.valueOf(value.toUpperCase());
    }
}
