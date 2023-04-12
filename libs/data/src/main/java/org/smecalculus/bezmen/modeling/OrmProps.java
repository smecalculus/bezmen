package org.smecalculus.bezmen.modeling;

import lombok.Builder;

@Builder
public record OrmProps(
        OrmMode mode
) {
}
