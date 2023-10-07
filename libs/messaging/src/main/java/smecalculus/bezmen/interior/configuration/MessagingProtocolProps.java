package smecalculus.bezmen.interior.configuration;

import java.util.Set;
import lombok.Builder;
import lombok.NonNull;

@Builder
public record MessagingProtocolProps(@NonNull Set<MessagingProtocolMode> protocolModes) {}
