package smecalculus.bezmen.core;

import java.util.UUID;
import lombok.Builder;
import lombok.NonNull;

/**
 * Model: domain entity
 */
@Builder
public record Sepulka(@NonNull UUID id, @NonNull String name) {}
