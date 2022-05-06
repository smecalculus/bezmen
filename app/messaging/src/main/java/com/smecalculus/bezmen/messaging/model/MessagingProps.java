package com.smecalculus.bezmen.messaging.model;

import lombok.Builder;
import lombok.NonNull;

@Builder
public record MessagingProps(
        @NonNull ReceptionProps receptionProps
) {
}
