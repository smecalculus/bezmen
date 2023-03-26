package org.smecalculus.bezmen.client;

import lombok.NonNull;

import java.util.UUID;

public record SepulkaRegRes(
        @NonNull UUID id,
        @NonNull String name
) {
}
