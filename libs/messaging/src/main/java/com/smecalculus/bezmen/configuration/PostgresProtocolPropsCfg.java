package com.smecalculus.bezmen.configuration;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PostgresProtocolPropsCfg {

    @NotBlank
    String url;

    @NotBlank
    String username;

    @NotBlank
    String password;

    @NotBlank
    String table;
}
