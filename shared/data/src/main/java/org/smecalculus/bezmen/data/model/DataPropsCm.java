package org.smecalculus.bezmen.data.model;

import com.typesafe.config.Optional;
import lombok.Data;
import org.smecalculus.bezmen.core.validation.ValueOfEnum;

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
