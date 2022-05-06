package com.smecalculus.bezmen.messaging.config;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MessagingCmMapper {

    @Mapping(target = "receptionProps", source = "reception")
    MessagingProps from(MessagingPropsCm messagingPropsCm);

    default MessagingProtocol from(String value) {
        return MessagingProtocol.valueOf(value.toUpperCase());
    }
}
