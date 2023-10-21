package smecalculus.bezmen.configuration;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Set;
import lombok.Data;
import smecalculus.bezmen.validation.ValueOfEnum;

public abstract class MessagingEdge {
    @Data
    public static class MessagingProps {
        @NotNull
        ProtocolProps protocol;

        @NotNull
        MappingProps mapping;
    }

    @Data
    public static class MappingProps {
        @NotNull
        @Size(min = 1)
        Set<@ValueOfEnum(MessagingMappingMode.class) String> modes;
    }

    @Data
    public static class ProtocolProps {
        @NotNull
        @Size(min = 1)
        Set<@ValueOfEnum(MessagingProtocolMode.class) String> modes;
    }
}
