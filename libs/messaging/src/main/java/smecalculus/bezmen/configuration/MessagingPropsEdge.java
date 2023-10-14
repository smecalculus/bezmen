package smecalculus.bezmen.configuration;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MessagingPropsEdge {

    @NotNull
    MessagingProtocolPropsEdge protocol;

    @NotNull
    MessageMappingPropsEdge mapping;
}
