package smecalculus.bezmen.storage;

import java.util.Optional;
import java.util.UUID;
import smecalculus.bezmen.core.ServerSide.AggregateState;
import smecalculus.bezmen.core.ServerSide.CreationState;
import smecalculus.bezmen.core.ServerSide.PreviewState;
import smecalculus.bezmen.core.ServerSide.TouchState;

/**
 * Port: server side
 */
public interface SepulkaDao {

    AggregateState add(AggregateState state);

    Optional<CreationState> getBy(String externalId);

    Optional<PreviewState> getBy(UUID internalId);

    int updateBy(TouchState state, UUID internalId);
}
