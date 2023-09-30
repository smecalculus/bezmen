package smecalculus.bezmen.configuration;

import lombok.Builder;
import lombok.NonNull;

@Builder
public record HttpProps(@NonNull MessageMappingProps mappingProps) {}
