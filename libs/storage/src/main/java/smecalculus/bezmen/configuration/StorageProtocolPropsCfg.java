package smecalculus.bezmen.configuration;

import com.typesafe.config.Optional;
import lombok.Data;
import smecalculus.bezmen.validation.ValueOfEnum;

@Data
public class StorageProtocolPropsCfg {

    @ValueOfEnum(StorageProtocolMode.class)
    String mode;

    @Optional
    H2PropsCfg h2;

    @Optional
    PostgresPropsCfg postgres;
}
