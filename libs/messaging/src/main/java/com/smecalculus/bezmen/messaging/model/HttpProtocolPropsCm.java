package com.smecalculus.bezmen.messaging.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class HttpProtocolPropsCm {

    @NotBlank
    String dummy;
}
