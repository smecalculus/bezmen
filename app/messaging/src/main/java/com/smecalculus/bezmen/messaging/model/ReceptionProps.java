package com.smecalculus.bezmen.messaging.model;

import lombok.Builder;
import lombok.NonNull;
import org.springframework.lang.Nullable;

import java.util.Set;

@Builder
public record ReceptionProps(
        @NonNull Set<MessagingProtocol> protocols,
        @Nullable HttpProtocolProps httpProtocolProps,
        @Nullable PostgresProtocolProps postgresProtocolProps
) {
}
