package smecalculus.bezmen.interior.configuration;

import lombok.Data;
import smecalculus.bezmen.interior.validation.ValueOfEnum;

@Data
public class StateMappingPropsCfg {

    @ValueOfEnum(StateMappingMode.class)
    private String mode;
}
