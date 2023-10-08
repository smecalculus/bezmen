package smecalculus.bezmen.interior.configuration;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class H2PropsCfg {

    @NotBlank
    String url;

    @NotBlank
    String username;

    @NotBlank
    String password;
}