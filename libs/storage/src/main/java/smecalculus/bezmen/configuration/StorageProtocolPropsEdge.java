package smecalculus.bezmen.configuration;

import com.typesafe.config.Optional;
import lombok.Data;
import smecalculus.bezmen.validation.ValueOfEnum;

@Data
public class StorageProtocolPropsEdge {

    @ValueOfEnum(StorageProtocolMode.class)
    String mode;

    @Optional
    H2PropsEdge h2;

    @Optional
    PostgresPropsEdge postgres;
}
