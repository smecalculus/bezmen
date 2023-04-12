package org.smecalculus.bezmen.configuration;

import lombok.Data;
import org.smecalculus.bezmen.modeling.OrmMode;
import org.smecalculus.bezmen.validation.ValueOfEnum;

@Data
public class OrmPropsCfg {

    @ValueOfEnum(OrmMode.class)
    private String mode;
}
