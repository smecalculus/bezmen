package com.smecalculus.bezmen.messaging;

import com.smecalculus.bezmen.messaging.model.MessagingProps;
import com.smecalculus.bezmen.messaging.model.MessagingPropsCm;
import com.smecalculus.bezmen.messaging.model.MessagingProtocol;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
interface MessagingMapper {

    @Mapping(target = "receptionProps", source = "reception")
    MessagingProps from(MessagingPropsCm messagingPropsCm);

    default MessagingProtocol from(String value) {
        return MessagingProtocol.valueOf(value.toUpperCase());
    }
}
