package smecalculus.bezmen.messaging;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

public abstract class SepulkaMessageEm {
    @Data
    public static class RegistrationRequest {
        @NotNull
        @Size(min = 1, max = 64)
        String externalId;
    }

    @Data
    public static class RegistrationResponse {
        String internalId;
    }

    @Data
    public static class ViewingRequest {
        @NotNull
        @Size(min = 36, max = 36)
        String internalId;
    }

    @Data
    public static class ViewingResponse {
        String externalId;
    }
}
