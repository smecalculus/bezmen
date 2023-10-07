package smecalculus.bezmen.interior.configuration;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MessagingPropsCfg {

    @NotNull
    MessagingProtocolPropsCfg protocol;

    @NotNull
    MessageMappingPropsCfg mapping;
}
