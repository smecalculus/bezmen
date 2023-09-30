package smecalculus.bezmen.configuration;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class HttpPropsCfg {

    @NotNull
    MessageMappingPropsCfg mapping;
}
