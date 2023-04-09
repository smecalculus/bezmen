package com.smecalculus.bezmen.configuration;

import edu.umd.cs.findbugs.annotations.Nullable;
import lombok.Builder;
import lombok.NonNull;

import java.util.Set;

@Builder
public record ReceptionProps(
        @NonNull Set<MessagingProtocol> protocols,
        @Nullable HttpProtocolProps httpProtocolProps,
        @Nullable PostgresProtocolProps postgresProtocolProps
) {
}
