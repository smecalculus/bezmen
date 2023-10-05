package smecalculus.bezmen.configuration;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface MessagingCfgMapper {

    @Mapping(source = "protocol", target = "protocolProps")
    @Mapping(source = "mapping", target = "mappingProps")
    MessagingProps toDomain(MessagingPropsCfg propsCfg);

    @Mapping(source = "modes", target = "protocolModes")
    MessagingProtocolProps toDomain(MessagingProtocolPropsCfg propsCfg);

    @Mapping(source = "modes", target = "mappingModes")
    MessageMappingProps toDomain(MessageMappingPropsCfg propsCfg);

    default MessagingProtocolMode toProtocolMode(String value) {
        return MessagingProtocolMode.valueOf(value.toUpperCase());
    }

    default MessageMappingMode toMappingMode(String value) {
        return MessageMappingMode.valueOf(value.toUpperCase());
    }
}
