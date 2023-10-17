package smecalculus.bezmen.messaging;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

public class EdgeSide {

    @Data
    public static class RegistrationRequest {
        @NotNull
        private String externalId;
    }

    @Data
    public static class RegistrationResponse {
        @NotNull
        private String externalId;
    }
}
