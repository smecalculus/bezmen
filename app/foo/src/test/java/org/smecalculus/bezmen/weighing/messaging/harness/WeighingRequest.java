package org.smecalculus.bezmen.weighing.messaging.harness;

import lombok.Builder;
import lombok.NonNull;

import java.util.Map;

@Builder
public record WeighingRequest<P, Q>(
        @NonNull Map<String, String> metadata,
        @NonNull P body,
        @NonNull Class<Q> responseType
) {
}
