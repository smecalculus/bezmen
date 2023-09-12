package smecalculus.bezmen.configuration.spec;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.ToString;

@Data
public class PostgresPropsCfg {

    @NotBlank
    String url;

    @NotBlank
    String username;

    @NotBlank
    @ToString.Exclude
    String password;
}
