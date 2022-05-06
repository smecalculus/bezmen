package com.smecalculus.bezmen.messaging.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

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
