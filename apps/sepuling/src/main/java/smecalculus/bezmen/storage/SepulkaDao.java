package smecalculus.bezmen.storage;

import java.util.Optional;
import java.util.UUID;
import smecalculus.bezmen.core.ServerSide.AggregateState;
import smecalculus.bezmen.core.ServerSide.ExistenceState;
import smecalculus.bezmen.core.ServerSide.PreviewState;
import smecalculus.bezmen.core.ServerSide.TouchState;

/**
 * Port: server side
 */
public interface SepulkaDao {

    AggregateState add(AggregateState state);

    Optional<ExistenceState> getBy(String externalId);

    Optional<PreviewState> getBy(UUID internalId);

    void updateBy(TouchState state, UUID internalId);
}
