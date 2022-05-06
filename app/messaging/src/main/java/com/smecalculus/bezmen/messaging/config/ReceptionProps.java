package com.smecalculus.bezmen.messaging.config;

import lombok.Builder;
import lombok.NonNull;

import java.util.Set;

@Builder
public record ReceptionProps(
        @NonNull Set<MessagingProtocol> protocols,
        HttpProtocolProps httpProtocolProps,
        PostgresProtocolProps postgresProtocolProps
) {
}
