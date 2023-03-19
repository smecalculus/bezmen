package org.smecalculus.bezmen.configuration;

import com.typesafe.config.Optional;
import lombok.Data;
import org.smecalculus.bezmen.core.validation.ValueOfEnum;

@Data
public class DataPropsDTO {

    @ValueOfEnum(DataMode.class)
    String mode;

    @Optional
    H2PropsDTO h2;

    @Optional
    PostgresPropsDTO postgres;
}
