package org.smecalculus.bezmen.config.data.spring;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Data
public class PostgresPropsCm {

    @NotBlank
    String url;

    @NotBlank
    String username;

    @NotBlank
    @ToString.Exclude
    String password;
}
