package com.smecalculus.bezmen.messaging.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MessagingPropsCm {

    @NotNull
    ReceptionPropsCm reception;
}
