package smecalculus.bezmen.configuration.spec;

import com.typesafe.config.Optional;
import lombok.Data;
import smecalculus.bezmen.validation.spec.ValueOfEnum;

@Data
public class VendorPropsCfg {

    @ValueOfEnum(VendorMode.class)
    String mode;

    @Optional
    H2PropsCfg h2;

    @Optional
    PostgresPropsCfg postgres;
}
