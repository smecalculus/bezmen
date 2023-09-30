package smecalculus.bezmen.configuration;

import lombok.Data;
import smecalculus.bezmen.validation.ValueOfEnum;

@Data
public class MessageMappingPropsCfg {

    @ValueOfEnum(MessageMappingMode.class)
    String mode;
}
