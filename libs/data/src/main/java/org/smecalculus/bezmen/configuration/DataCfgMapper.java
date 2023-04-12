package org.smecalculus.bezmen.configuration;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.smecalculus.bezmen.modeling.DataProps;
import org.smecalculus.bezmen.modeling.OrmMode;
import org.smecalculus.bezmen.modeling.OrmProps;
import org.smecalculus.bezmen.modeling.VendorMode;
import org.smecalculus.bezmen.modeling.VendorProps;

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
