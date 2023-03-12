package org.smecalculus.bezmen.foo.service;

import lombok.Builder;

import java.util.UUID;

@Builder
public record Weighing(
        UUID id
) {
}
