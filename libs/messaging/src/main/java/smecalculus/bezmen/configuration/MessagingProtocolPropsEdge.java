package smecalculus.bezmen.configuration;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Set;
import lombok.Data;
import smecalculus.bezmen.validation.ValueOfEnum;

@Data
public class MessagingProtocolPropsEdge {

    @NotNull
    @Size(min = 1)
    Set<@ValueOfEnum(MessagingProtocolMode.class) String> modes;
}
