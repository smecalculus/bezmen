package org.smecalculus.bezmen.configuration;

import edu.umd.cs.findbugs.annotations.Nullable;
import lombok.Builder;
import lombok.NonNull;

@Builder
public record DataProps(
        @NonNull DataMode mode,
        @Nullable H2Props h2Props,
        @Nullable PostgresProps postgresProps
) {
}
