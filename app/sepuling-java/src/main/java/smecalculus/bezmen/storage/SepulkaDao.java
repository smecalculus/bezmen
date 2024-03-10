package smecalculus.bezmen.storage;

import java.util.Optional;
import java.util.UUID;
import smecalculus.bezmen.core.SepulkaStateDm;

/**
 * Port: server side
 */
public interface SepulkaDao {
    SepulkaStateDm.AggregateRoot addNew(SepulkaStateDm.AggregateRoot state);

    Optional<SepulkaStateDm.Existence> getBy(String externalId);

    Optional<SepulkaStateDm.Viewing> getBy(UUID internalId);

    void touchBy(UUID internalId, SepulkaStateDm.Touch state);
}
