package smecalculus.bezmen.core;

import java.util.UUID;
import smecalculus.bezmen.core.ServerSide.CreationState;
import smecalculus.bezmen.core.ServerSide.StorageState;

public class ServerSideEg {
    public static StorageState.Builder storageState() {
        return StorageState.builder()
                .internalId(UUID.randomUUID())
                .externalId(UUID.randomUUID().toString());
    }

    public static CreationState.Builder creationState() {
        return CreationState.builder().internalId(UUID.randomUUID());
    }
}
