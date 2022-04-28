package org.smecalculus.bezmen.config.data.spring;

import lombok.Data;
import org.smecalculus.bezmen.config.core.ValueOfEnum;
import org.smecalculus.bezmen.config.data.contract.DataMode;

@Data
public class DataPropsCm {

    @ValueOfEnum(DataMode.class)
    String mode;

    H2PropsCm h2Props;

    PostgresPropsCm postgresProps;
}
