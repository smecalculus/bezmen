package org.smecalculus.bezmen.config.data;

import lombok.Data;
import lombok.ToString;

@Data
public class PostgresPropsCm {
    String url;
    String username;
    @ToString.Exclude
    String password;
}
