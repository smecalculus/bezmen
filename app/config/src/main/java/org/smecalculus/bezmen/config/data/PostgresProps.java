package org.smecalculus.bezmen.config.data;

import lombok.Builder;
import lombok.ToString;

@Builder
public record PostgresProps(
        String url,
        String username,
        @ToString.Exclude String password
) {
}
