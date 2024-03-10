package smecalculus.bezmen.core;

import java.util.UUID;
import lombok.Builder;
import lombok.NonNull;

public class SepulkaMessageDm {
    @Builder
    public record RegistrationRequest(@NonNull String externalId) {}

    @Builder
    public record RegistrationResponse(@NonNull UUID internalId) {}

    @Builder
    public record ViewingRequest(@NonNull UUID internalId) {}

    @Builder
    public record ViewingResponse(@NonNull String externalId) {}
}
