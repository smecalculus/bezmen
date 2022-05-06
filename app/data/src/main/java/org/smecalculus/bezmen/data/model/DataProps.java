package org.smecalculus.bezmen.data.model;

import lombok.Builder;
import lombok.NonNull;
import org.springframework.lang.Nullable;

@Builder
public record DataProps(
        @NonNull DataMode mode,
        @Nullable H2Props h2Props,
        @Nullable PostgresProps postgresProps
) {
}
