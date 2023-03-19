package com.smecalculus.bezmen.messaging.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PostgresProtocolPropsCm {

    @NotBlank
    String url;

    @NotBlank
    String username;

    @NotBlank
    String password;

    @NotBlank
    String table;
}
