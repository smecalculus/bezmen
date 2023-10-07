package smecalculus.bezmen.interior.configuration;

import lombok.Builder;
import lombok.NonNull;

@Builder
public record MessagingProps(
        @NonNull MessagingProtocolProps protocolProps, @NonNull MessageMappingProps mappingProps) {}
