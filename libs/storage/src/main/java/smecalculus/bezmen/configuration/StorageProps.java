package smecalculus.bezmen.configuration;

import lombok.Builder;
import lombok.NonNull;

@Builder
public record StorageProps(@NonNull VendorProps vendorProps, @NonNull OrmProps ormProps) {}
