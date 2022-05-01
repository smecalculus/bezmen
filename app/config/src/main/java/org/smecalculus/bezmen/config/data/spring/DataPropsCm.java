package org.smecalculus.bezmen.config.data.spring;

import com.typesafe.config.Optional;
import lombok.Data;
import org.smecalculus.bezmen.config.core.ValueOfEnum;
import org.smecalculus.bezmen.config.data.contract.DataMode;

import javax.validation.Valid;

@Data
public class DataPropsCm {

    @ValueOfEnum(DataMode.class)
    String mode;

    @Optional
    @Valid
    H2PropsCm h2;

    @Optional
    @Valid
    PostgresPropsCm postgres;
}
