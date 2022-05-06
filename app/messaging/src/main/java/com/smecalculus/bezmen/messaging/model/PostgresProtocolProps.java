package com.smecalculus.bezmen.messaging.model;

import lombok.Builder;
import lombok.NonNull;
import lombok.ToString;

@Builder
public record PostgresProtocolProps(
        @NonNull String url,
        @NonNull String username,
        @NonNull @ToString.Exclude String password,
        @NonNull String table
) {
}
