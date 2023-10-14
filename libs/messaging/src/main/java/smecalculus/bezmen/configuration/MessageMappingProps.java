package smecalculus.bezmen.configuration;

import java.util.Set;
import lombok.Builder;
import lombok.NonNull;

@Builder
public record MessageMappingProps(@NonNull Set<MessageMappingMode> mappingModes) {}
