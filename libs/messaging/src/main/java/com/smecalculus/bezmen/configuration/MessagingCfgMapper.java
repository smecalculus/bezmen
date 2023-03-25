package com.smecalculus.bezmen.configuration;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MessagingCfgMapper {

    @Mapping(target = "receptionProps", source = "reception")
    MessagingProps toDomain(MessagingPropsCfg messagingPropsCfg);

    default MessagingProtocol toDomain(String value) {
        return MessagingProtocol.valueOf(value.toUpperCase());
    }
}
