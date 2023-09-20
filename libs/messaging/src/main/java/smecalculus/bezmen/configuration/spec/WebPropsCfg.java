package smecalculus.bezmen.configuration.spec;

import lombok.Data;
import smecalculus.bezmen.validation.spec.ValueOfEnum;

@Data
public class WebPropsCfg {

    @ValueOfEnum(WebMode.class)
    String mode;
}
