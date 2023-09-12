package smecalculus.bezmen.configuration.spec;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface DataCfgMapper {

    @Mapping(source = "vendor", target = "vendorProps")
    @Mapping(source = "orm", target = "ormProps")
    DataProps toDomain(DataPropsCfg dataPropsCfg);

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
