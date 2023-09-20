package smecalculus.bezmen.configuration.spec;

import lombok.Builder;
import lombok.NonNull;

@Builder
public record DataProps(@NonNull VendorProps vendorProps, @NonNull OrmProps ormProps) {}
