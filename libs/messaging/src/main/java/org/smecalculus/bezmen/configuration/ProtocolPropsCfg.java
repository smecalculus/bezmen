package org.smecalculus.bezmen.configuration;

import com.typesafe.config.Optional;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.smecalculus.bezmen.validation.ValueOfEnum;

import java.util.Set;

@Data
public class ProtocolPropsCfg {

    @NotNull
    @Size(min = 1)
    Set<@ValueOfEnum(MessagingProtocol.class) String> types;

    @Optional
    HttpPropsCfg http;
}
