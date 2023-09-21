package smecalculus.bezmen.configuration;

import lombok.Data;
import smecalculus.bezmen.validation.ValueOfEnum;

@Data
public class OrmPropsCfg {

    @ValueOfEnum(OrmMode.class)
    private String mode;
}
