package com.smecalculus.bezmen.configuration;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class HttpProtocolPropsCfg {

    @NotBlank
    String dummy;
}
