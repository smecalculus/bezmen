package org.smecalculus.bezmen.foo.messaging.harness;

import lombok.Builder;

import java.util.Map;

@Builder
public record WeighingResponse<Q>(
        Map<String, String> metadata,
        Q body
) {
}
