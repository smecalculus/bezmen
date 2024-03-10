package smecalculus.bezmen.storage;

import java.util.Optional;
import java.util.UUID;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import smecalculus.bezmen.core.SepulkaStateDm;
import smecalculus.bezmen.storage.springdata.SepulkaRepository;

@RequiredArgsConstructor
public class SepulkaDaoSpringData implements SepulkaDao {

    @NonNull
    private SepulkaStateMapper mapper;

    @NonNull
    private SepulkaRepository repository;

    @Override
    public SepulkaStateDm.AggregateRoot addNew(@NonNull SepulkaStateDm.AggregateRoot state) {
        var stateEdge = mapper.toEdge(state);
        repository.insert(stateEdge);
        return state;
    }

    @Override
    public Optional<SepulkaStateDm.Existence> getBy(@NonNull String externalId) {
        return repository.findByExternalId(externalId).map(mapper::toDomain);
    }

    @Override
    public Optional<SepulkaStateDm.Viewing> getBy(@NonNull UUID internalId) {
        return repository.findByInternalId(internalId).map(mapper::toDomain);
    }

    @Override
    public void touchBy(@NonNull UUID internalId, @NonNull SepulkaStateDm.Touch state) {
        var stateEdge = mapper.toEdge(state);
        var matchedCount = repository.updateBy(internalId, stateEdge);
        if (matchedCount == 0) {
            throw new ContentionException();
        }
    }
}
