package smecalculus.bezmen.configuration;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface StorageCfgMapper {

    @Mapping(source = "protocol", target = "protocolProps")
    @Mapping(source = "mapping", target = "mappingProps")
    StorageProps toDomain(StoragePropsCfg propsCfg);

    @Mapping(source = "mode", target = "protocolMode")
    @Mapping(source = "h2", target = "h2Props")
    @Mapping(source = "postgres", target = "postgresProps")
    StorageProtocolProps toDomain(StorageProtocolPropsCfg propsCfg);

    @Mapping(source = "mode", target = "mappingMode")
    StateMappingProps toDomain(StateMappingPropsCfg propsCfg);

    default StorageProtocolMode toProtocolMode(String mode) {
        return StorageProtocolMode.valueOf(mode.toUpperCase());
    }

    default StateMappingMode toMappingMode(String mode) {
        return StateMappingMode.valueOf(mode.toUpperCase());
    }
}
