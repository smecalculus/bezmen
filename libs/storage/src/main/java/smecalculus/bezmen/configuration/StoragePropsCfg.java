package smecalculus.bezmen.configuration;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class StoragePropsCfg {

    @NotNull
    VendorPropsCfg vendor;

    @NotNull
    OrmPropsCfg orm;
}
