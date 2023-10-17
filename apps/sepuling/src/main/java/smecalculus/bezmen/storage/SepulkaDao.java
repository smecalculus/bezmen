package smecalculus.bezmen.storage;

import java.util.Optional;
import java.util.UUID;
import smecalculus.bezmen.core.ServerSide.CreationState;
import smecalculus.bezmen.core.ServerSide.PreviewState;
import smecalculus.bezmen.core.ServerSide.StorageState;
import smecalculus.bezmen.core.ServerSide.TouchState;

/**
 * Port: server side
 */
public interface SepulkaDao {

    StorageState add(StorageState state);

    Optional<CreationState> getBy(String externalId);

    Optional<PreviewState> getBy(UUID internalId);

    void updateBy(TouchState state, UUID internalId);
}
