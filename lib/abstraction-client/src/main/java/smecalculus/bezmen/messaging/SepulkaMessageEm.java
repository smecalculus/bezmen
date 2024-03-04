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
        String externalId;
    }

    @Data
    public static class SearchResponse {
        String externalId;
    }

    @Data
    public static class ViewRequest {
        @NotNull
        @Size(min = 1, max = 64)
        String externalId;
    }

    @Data
    public static class ViewResponse {
        String externalId;
    }
}
