package com.smecalculus.bezmen.configuration;

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
