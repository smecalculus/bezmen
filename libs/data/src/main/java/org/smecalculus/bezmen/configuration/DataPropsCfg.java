package org.smecalculus.bezmen.configuration;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DataPropsCfg {

    @NotNull
    VendorPropsCfg vendor;

    @NotNull
    OrmPropsCfg orm;
}
