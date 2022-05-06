package com.smecalculus.bezmen.messaging.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class HttpProtocolPropsCm {

    @NotBlank
    String dummy;
}
