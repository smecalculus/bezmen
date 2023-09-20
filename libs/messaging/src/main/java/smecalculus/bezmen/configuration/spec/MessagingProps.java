package smecalculus.bezmen.configuration.spec;

import lombok.Builder;
import lombok.NonNull;

@Builder
public record MessagingProps(@NonNull ProtocolProps protocolProps) {}
