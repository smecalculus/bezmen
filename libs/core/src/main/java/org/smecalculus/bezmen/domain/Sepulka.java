package org.smecalculus.bezmen.domain;

import lombok.Builder;
import lombok.NonNull;

import java.util.UUID;

@Builder
public record Sepulka(
        @NonNull UUID id,
        @NonNull String name
) {
}
