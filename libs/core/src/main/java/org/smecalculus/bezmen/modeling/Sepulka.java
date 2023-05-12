package org.smecalculus.bezmen.modeling;

import java.util.UUID;
import lombok.Builder;
import lombok.NonNull;

@Builder
public record Sepulka(@NonNull UUID id, @NonNull String name) {}
