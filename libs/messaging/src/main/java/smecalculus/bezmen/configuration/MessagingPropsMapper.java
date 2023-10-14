package smecalculus.bezmen.configuration;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface MessagingPropsMapper {

    @Mapping(source = "protocol", target = "protocolProps")
    @Mapping(source = "mapping", target = "mappingProps")
    MessagingProps toDomain(MessagingPropsEdge propsEdge);

    @Mapping(source = "modes", target = "protocolModes")
    MessagingProtocolProps toDomain(MessagingProtocolPropsEdge propsEdge);

    @Mapping(source = "modes", target = "mappingModes")
    MessageMappingProps toDomain(MessageMappingPropsEdge propsEdge);

    default MessagingProtocolMode toProtocolMode(String value) {
        return MessagingProtocolMode.valueOf(value.toUpperCase());
    }

    default MessageMappingMode toMappingMode(String value) {
        return MessageMappingMode.valueOf(value.toUpperCase());
    }
}
