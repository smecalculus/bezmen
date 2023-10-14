package smecalculus.bezmen.configuration;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class StoragePropsEdge {

    @NotNull
    StorageProtocolPropsEdge protocol;

    @NotNull
    StateMappingPropsEdge mapping;
}
