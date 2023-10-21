package smecalculus.bezmen.configuration;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import smecalculus.bezmen.mapping.EdgeMapper;

@Mapper
public interface MessagingPropsMapper extends EdgeMapper {
    @Mapping(source = "protocol", target = "protocolProps")
    @Mapping(source = "mapping", target = "mappingProps")
    MessagingDomain.MessagingProps toDomain(MessagingEdge.MessagingProps propsEdge);

    @Mapping(source = "modes", target = "protocolModes")
    MessagingDomain.ProtocolProps toDomain(MessagingEdge.ProtocolProps propsEdge);

    @Mapping(source = "modes", target = "mappingModes")
    MessagingDomain.MappingProps toDomain(MessagingEdge.MappingProps propsEdge);

    default MessagingProtocolMode toProtocolMode(String value) {
        return MessagingProtocolMode.valueOf(value.toUpperCase());
    }

    default MessagingMappingMode toMappingMode(String value) {
        return MessagingMappingMode.valueOf(value.toUpperCase());
    }
}
