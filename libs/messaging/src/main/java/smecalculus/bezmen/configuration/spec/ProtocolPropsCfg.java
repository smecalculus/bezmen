package smecalculus.bezmen.configuration.spec;

import com.typesafe.config.Optional;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Set;
import lombok.Data;
import smecalculus.bezmen.validation.spec.ValueOfEnum;

@Data
public class ProtocolPropsCfg {

    @NotNull
    @Size(min = 1)
    Set<@ValueOfEnum(MessagingProtocol.class) String> types;

    @Optional
    HttpPropsCfg http;
}
