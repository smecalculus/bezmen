package smecalculus.bezmen.storage;

import java.util.Optional;
import java.util.UUID;
import smecalculus.bezmen.core.StateDm;
import smecalculus.bezmen.core.StateDm.AggregateRoot;
import smecalculus.bezmen.core.StateDm.Existence;
import smecalculus.bezmen.core.StateDm.Preview;
import smecalculus.bezmen.core.StateDm.Touch;

/**
 * Port: server side
 */
public interface SepulkaDao {
    StateDm.AggregateRoot add(AggregateRoot state);

    Optional<Existence> getBy(String externalId);

    Optional<Preview> getBy(UUID internalId);

    void updateBy(Touch state, UUID internalId);
}
