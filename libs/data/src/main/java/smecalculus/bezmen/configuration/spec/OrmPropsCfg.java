package smecalculus.bezmen.configuration.spec;

import lombok.Data;
import smecalculus.bezmen.validation.spec.ValueOfEnum;

@Data
public class OrmPropsCfg {

    @ValueOfEnum(OrmMode.class)
    private String mode;
}
