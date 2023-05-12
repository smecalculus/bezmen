package org.smecalculus.bezmen.modeling;

import lombok.Builder;
import lombok.NonNull;
import lombok.ToString;

@Builder
public record PostgresProps(
        @NonNull String url, @NonNull String username, @NonNull @ToString.Exclude String password) {}
