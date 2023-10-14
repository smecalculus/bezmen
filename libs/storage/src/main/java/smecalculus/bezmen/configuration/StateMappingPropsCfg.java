package smecalculus.bezmen.configuration;

import lombok.Data;
import smecalculus.bezmen.validation.ValueOfEnum;

@Data
public class StateMappingPropsCfg {

    @ValueOfEnum(StateMappingMode.class)
    private String mode;
}
