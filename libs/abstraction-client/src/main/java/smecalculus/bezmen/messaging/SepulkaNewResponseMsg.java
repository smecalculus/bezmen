package smecalculus.bezmen.messaging;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * Model: edge slice
 */
@Data
public class SepulkaNewResponseMsg {
    @NotNull
    private String id;
}
