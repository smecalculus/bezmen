package org.smecalculus.bezmen.configuration;

import lombok.Data;
import org.smecalculus.bezmen.validation.ValueOfEnum;

@Data
public class WebPropsCfg {

    @ValueOfEnum(WebMode.class)
    String mode;
}
