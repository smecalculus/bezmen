package org.smecalculus.bezmen.modeling;

import edu.umd.cs.findbugs.annotations.Nullable;
import lombok.Builder;
import lombok.NonNull;

@Builder
public record VendorProps(
        @NonNull VendorMode mode,
        @Nullable H2Props h2Props,
        @Nullable PostgresProps postgresProps
) {
}
