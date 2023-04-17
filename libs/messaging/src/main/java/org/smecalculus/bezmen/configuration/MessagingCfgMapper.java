package org.smecalculus.bezmen.configuration;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface MessagingCfgMapper {

    @Mapping(source = "protocol", target = "protocolProps")
    MessagingProps toDomain(MessagingPropsCfg messagingPropsCfg);

    @Mapping(source = "http", target = "httpProps")
    ProtocolProps toDomain(ProtocolPropsCfg protocolPropsCfg);

    @Mapping(source = "mvc", target = "webProps")
    HttpProps toDomain(HttpPropsCfg httpPropsCfg);

    @Mapping(source = "mode", target = "webMode")
    WebProps toDomain(WebPropsCfg webPropsCfg);

    default MessagingProtocol toMessagingProtocol(String value) {
        return MessagingProtocol.valueOf(value.toUpperCase());
    }

    default WebMode toWebMode(String value) {
        return WebMode.valueOf(value.toUpperCase());
    }
}
