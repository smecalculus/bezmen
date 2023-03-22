package org.smecalculus.bezmen.configuration;

import com.typesafe.config.Optional;
import lombok.Data;
import org.smecalculus.bezmen.validation.ValueOfEnum;

@Data
public class DataPropsCfg {

    @ValueOfEnum(DataMode.class)
    String mode;

    @Optional
    H2PropsCfg h2;

    @Optional
    PostgresPropsCfg postgres;
}
