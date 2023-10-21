package smecalculus.bezmen.configuration;

import java.util.Set;
import lombok.Builder;
import lombok.NonNull;

public abstract class MessagingDomain {
    @Builder
    public record MessagingProps(
            @NonNull MessagingDomain.ProtocolProps protocolProps, @NonNull MessagingDomain.MappingProps mappingProps) {}

    @Builder
    public record ProtocolProps(@NonNull Set<MessagingProtocolMode> protocolModes) {}

    @Builder
    public record MappingProps(@NonNull Set<MessagingMappingMode> mappingModes) {}
}
