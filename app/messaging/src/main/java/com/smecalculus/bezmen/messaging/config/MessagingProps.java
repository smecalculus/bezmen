package com.smecalculus.bezmen.messaging.config;

import lombok.Builder;
import lombok.NonNull;

@Builder
public record MessagingProps(
        @NonNull ReceptionProps receptionProps
) {
}
