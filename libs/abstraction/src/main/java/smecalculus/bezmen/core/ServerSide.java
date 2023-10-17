package smecalculus.bezmen.core;

import java.util.UUID;
import lombok.Builder;
import lombok.NonNull;

public class ServerSide {

    @Builder
    public record StorageState(@NonNull UUID internalId, @NonNull String externalId) {}

    @Builder
    public record CreationState(@NonNull UUID internalId) {}

    @Builder
    public record PreviewState(@NonNull String externalId) {}

    @Builder
    public record TouchState(int version) {}
}
