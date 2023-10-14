package smecalculus.bezmen.configuration;

import lombok.Builder;
import lombok.NonNull;

@Builder
public record StorageProps(@NonNull StorageProtocolProps protocolProps, @NonNull StateMappingProps mappingProps) {}
