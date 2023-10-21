package smecalculus.bezmen.storage;

import java.util.Optional;
import java.util.UUID;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import smecalculus.bezmen.core.StateDomain;
import smecalculus.bezmen.storage.springdata.SepulkaRepository;

@RequiredArgsConstructor
public class SepulkaDaoSpringData implements SepulkaDao {

    @NonNull
    private SepulkaStateMapper mapper;

    @NonNull
    private SepulkaRepository repository;

    @Override
    public StateDomain.AggregateState add(@NonNull StateDomain.AggregateState state) {
        var stateEdge = repository.save(mapper.toEdge(state));
        return mapper.toDomain(stateEdge);
    }

    @Override
    public Optional<StateDomain.ExistenceState> getBy(@NonNull String externalId) {
        return repository
                .findByExternalId(externalId, StateEdge.ExistenceState.class)
                .map(mapper::toDomain);
    }

    @Override
    public Optional<StateDomain.PreviewState> getBy(@NonNull UUID internalId) {
        return repository
                .findByInternalId(internalId.toString(), StateEdge.PreviewState.class)
                .map(mapper::toDomain);
    }

    @Override
    public void updateBy(StateDomain.TouchState state, UUID internalId) {
        var stateEdge = mapper.toEdge(state);
        var matchedCount = repository.updateBy(stateEdge, internalId.toString());
        if (matchedCount == 0) {
            throw new ContentionException();
        }
    }
}
