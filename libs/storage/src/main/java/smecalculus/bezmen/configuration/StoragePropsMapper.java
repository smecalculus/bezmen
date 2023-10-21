package smecalculus.bezmen.configuration;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import smecalculus.bezmen.mapping.EdgeMapper;

@Mapper
public interface StoragePropsMapper extends EdgeMapper {

    @Mapping(source = "protocol", target = "protocolProps")
    @Mapping(source = "mapping", target = "mappingProps")
    StorageProps toDomain(StoragePropsEdge propsEdge);

    @Mapping(source = "mode", target = "protocolMode")
    @Mapping(source = "h2", target = "h2Props")
    @Mapping(source = "postgres", target = "postgresProps")
    StorageProtocolProps toDomain(StorageProtocolPropsEdge propsEdge);

    @Mapping(source = "mode", target = "mappingMode")
    StateMappingProps toDomain(StateMappingPropsEdge propsEdge);

    default StorageProtocolMode toProtocolMode(String mode) {
        return StorageProtocolMode.valueOf(mode.toUpperCase());
    }

    default StateMappingMode toMappingMode(String mode) {
        return StateMappingMode.valueOf(mode.toUpperCase());
    }
}
