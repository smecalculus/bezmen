package com.smecalculus.bezmen.configuration;

import lombok.Builder;
import lombok.NonNull;

@Builder
public record MessagingProps(
        @NonNull ReceptionProps receptionProps
) {
}
