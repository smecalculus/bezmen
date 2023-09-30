package smecalculus.bezmen.configuration;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface MessagingCfgMapper {

    @Mapping(source = "protocol", target = "protocolProps")
    MessagingProps toDomain(MessagingPropsCfg messagingPropsCfg);

    @Mapping(source = "modes", target = "protocolModes")
    @Mapping(source = "http", target = "httpProps")
    MessagingProtocolProps toDomain(MessagingProtocolPropsCfg protocolPropsCfg);

    @Mapping(source = "mapping", target = "mappingProps")
    HttpProps toDomain(HttpPropsCfg httpPropsCfg);

    @Mapping(source = "mode", target = "mappingMode")
    MessageMappingProps toDomain(MessageMappingPropsCfg mappingPropsCfg);

    default MessagingProtocolMode toProtocolMode(String value) {
        return MessagingProtocolMode.valueOf(value.toUpperCase());
    }

    default MessageMappingMode toMappingMode(String value) {
        return MessageMappingMode.valueOf(value.toUpperCase());
    }
}
