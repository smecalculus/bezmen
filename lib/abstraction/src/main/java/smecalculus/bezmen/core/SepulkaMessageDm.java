package smecalculus.bezmen.core;

import lombok.Builder;
import lombok.NonNull;

public class SepulkaMessageDm {
    @Builder
    public record RegistrationRequest(@NonNull String externalId) {}

    @Builder
    public record RegistrationResponse(@NonNull String externalId) {}

    @Builder
    public record ViewRequest(@NonNull String externalId) {}

    @Builder
    public record ViewResponse(@NonNull String externalId) {}
}
