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
    public record ViewRequest(@NonNull UUID internalId) {}

    @Builder
    public record ViewResponse(@NonNull String externalId) {}
}
