package smecalculus.bezmen.core;

import lombok.Builder;
import lombok.NonNull;

/**
 * Model: domain slice
 */
@Builder
public record SepulkaNewRequest(@NonNull String externalId) {}
