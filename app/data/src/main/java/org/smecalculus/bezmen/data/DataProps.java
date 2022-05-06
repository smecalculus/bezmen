package org.smecalculus.bezmen.data;

import lombok.Builder;
import lombok.NonNull;

@Builder
public record DataProps(
        @NonNull DataMode mode,
        H2Props h2Props,
        PostgresProps postgresProps
) {
}
