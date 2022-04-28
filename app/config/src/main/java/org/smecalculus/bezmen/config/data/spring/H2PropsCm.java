package org.smecalculus.bezmen.config.data.spring;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class H2PropsCm {
    @NotBlank
    String url;

    @NotBlank
    String username;

    @NotBlank
    String password;
}
