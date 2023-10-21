package smecalculus.bezmen.configuration;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import smecalculus.bezmen.mapping.EdgeMapper;

@Mapper
public interface StoragePropsMapper extends EdgeMapper {
    @Mapping(source = "protocol", target = "protocolProps")
    @Mapping(source = "mapping", target = "mappingProps")
    StorageDomain.StorageProps toDomain(StorageEdge.StorageProps propsEdge);

    @Mapping(source = "mode", target = "protocolMode")
    @Mapping(source = "h2", target = "h2Props")
    @Mapping(source = "postgres", target = "postgresProps")
    StorageDomain.ProtocolProps toDomain(StorageEdge.ProtocolProps propsEdge);

    @Mapping(source = "mode", target = "mappingMode")
    StorageDomain.MappingProps toDomain(StorageEdge.MappingProps propsEdge);

    default StorageProtocolMode toProtocolMode(String mode) {
        return StorageProtocolMode.valueOf(mode.toUpperCase());
    }

    default StorageMappingMode toMappingMode(String mode) {
        return StorageMappingMode.valueOf(mode.toUpperCase());
    }
}
