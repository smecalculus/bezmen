package com.smecalculus.bezmen.messaging.config;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
public class MessagingPropsCm {

    @Valid
    @NotNull
    ReceptionPropsCm reception;
}
