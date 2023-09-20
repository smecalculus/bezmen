package smecalculus.bezmen.configuration.spec;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DataPropsCfg {

    @NotNull
    VendorPropsCfg vendor;

    @NotNull
    OrmPropsCfg orm;
}
