package com.smecalculus.bezmen.messaging.model;

import com.typesafe.config.Optional;
import lombok.Data;
import org.smecalculus.bezmen.core.validation.ValueOfEnum;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
public class ReceptionPropsCm {

    @NotNull
    @Size(min = 1)
    Set<@ValueOfEnum(MessagingProtocol.class) String> protocols;

    @Valid
    @Optional
    HttpProtocolPropsCm http;

    @Valid
    @Optional
    PostgresProtocolPropsCm postgres;
}
