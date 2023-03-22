package com.smecalculus.bezmen.messaging.model;

import com.typesafe.config.Optional;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.smecalculus.bezmen.validation.ValueOfEnum;

import java.util.Set;

@Data
public class ReceptionPropsCm {

    @NotNull
    @Size(min = 1)
    Set<@ValueOfEnum(MessagingProtocol.class) String> protocols;

    @Optional
    HttpProtocolPropsCm http;

    @Optional
    PostgresProtocolPropsCm postgres;
}
