package smecalculus.bezmen.configuration;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface StorageCfgMapper {

    @Mapping(source = "vendor", target = "vendorProps")
    @Mapping(source = "orm", target = "ormProps")
    StorageProps toDomain(StoragePropsCfg storagePropsCfg);

    @Mapping(source = "h2", target = "h2Props")
    @Mapping(source = "postgres", target = "postgresProps")
    VendorProps toDomain(VendorPropsCfg vendorPropsCfg);

    OrmProps toDomain(OrmPropsCfg ormPropsCfg);

    default VendorMode toVendorMode(String mode) {
        return VendorMode.valueOf(mode.toUpperCase());
    }

    default OrmMode toOrmMode(String mode) {
        return OrmMode.valueOf(mode.toUpperCase());
    }
}
