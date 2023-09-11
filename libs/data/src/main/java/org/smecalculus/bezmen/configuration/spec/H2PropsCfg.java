package org.smecalculus.bezmen.configuration.spec;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class H2PropsCfg {

    @NotBlank
    String url;

    @NotBlank
    String username;

    @NotBlank
    String password;
}
