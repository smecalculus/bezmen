package smecalculus.bezmen.configuration;

import lombok.Data;
import smecalculus.bezmen.validation.ValueOfEnum;

@Data
public class WebPropsCfg {

    @ValueOfEnum(WebMode.class)
    String mode;
}
