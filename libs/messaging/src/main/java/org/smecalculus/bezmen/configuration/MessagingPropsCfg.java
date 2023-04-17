package org.smecalculus.bezmen.configuration;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MessagingPropsCfg {

    @NotNull
    ProtocolPropsCfg protocol;
}
