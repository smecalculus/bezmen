package smecalculus.bezmen.configuration;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class StoragePropsCfg {

    @NotNull
    StorageProtocolPropsCfg protocol;

    @NotNull
    StateMappingPropsCfg mapping;
}
