package org.smecalculus.bezmen.modeling;

import lombok.Builder;
import lombok.NonNull;

@Builder
public record DataProps(
        @NonNull VendorProps vendorProps,
        @NonNull OrmProps ormProps
) {
}
