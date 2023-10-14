package smecalculus.bezmen.configuration;

import lombok.Data;
import smecalculus.bezmen.validation.ValueOfEnum;

@Data
public class StateMappingPropsEdge {

    @ValueOfEnum(StateMappingMode.class)
    private String mode;
}
