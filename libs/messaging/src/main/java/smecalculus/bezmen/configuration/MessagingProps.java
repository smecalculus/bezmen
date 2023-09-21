package smecalculus.bezmen.configuration;

import lombok.Builder;
import lombok.NonNull;

@Builder
public record MessagingProps(@NonNull ProtocolProps protocolProps) {}
