package smecalculus.bezmen.configuration;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import smecalculus.bezmen.mapping.EdgeMapper;

@Mapper
public interface StoragePropsMapper extends EdgeMapper {

    @Mapping(source = "protocol", target = "protocolProps")
    @Mapping(source = "mapping", target = "mappingProps")
    ServerSide.StorageProps toServer(EdgeSide.StorageProps propsEdge);

    @Mapping(source = "mode", target = "protocolMode")
    @Mapping(source = "h2", target = "h2Props")
    @Mapping(source = "postgres", target = "postgresProps")
    ServerSide.StorageProtocolProps toServer(EdgeSide.StorageProtocolProps propsEdge);

    @Mapping(source = "mode", target = "mappingMode")
    ServerSide.StateMappingProps toServer(EdgeSide.StateMappingProps propsEdge);

    default StorageProtocolMode toProtocolMode(String mode) {
        return StorageProtocolMode.valueOf(mode.toUpperCase());
    }

    default StateMappingMode toMappingMode(String mode) {
        return StateMappingMode.valueOf(mode.toUpperCase());
    }
}
