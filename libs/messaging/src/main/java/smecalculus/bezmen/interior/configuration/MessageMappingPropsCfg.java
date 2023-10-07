package smecalculus.bezmen.interior.configuration;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Set;
import lombok.Data;
import smecalculus.bezmen.interior.validation.ValueOfEnum;

@Data
public class MessageMappingPropsCfg {

    @NotNull
    @Size(min = 1)
    Set<@ValueOfEnum(MessageMappingMode.class) String> modes;
}
