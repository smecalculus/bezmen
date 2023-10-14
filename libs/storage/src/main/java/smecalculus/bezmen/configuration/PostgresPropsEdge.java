package smecalculus.bezmen.configuration;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.ToString;

@Data
public class PostgresPropsEdge {

    @NotBlank
    String url;

    @NotBlank
    String username;

    @NotBlank
    @ToString.Exclude
    String password;
}
