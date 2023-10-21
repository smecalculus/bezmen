package smecalculus.bezmen.storage;

import java.util.Optional;
import java.util.UUID;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import smecalculus.bezmen.core.ServerSide;
import smecalculus.bezmen.storage.springdata.SepulkaRepository;

@RequiredArgsConstructor
public class SepulkaDaoSpringData implements SepulkaDao {

    @NonNull
    private SepulkaStateMapper mapper;

    @NonNull
    private SepulkaRepository repository;

    @Override
    public ServerSide.AggregateState add(@NonNull ServerSide.AggregateState state) {
        var stateEdge = repository.save(mapper.toEdge(state));
        return mapper.toDomain(stateEdge);
    }

    @Override
    public Optional<ServerSide.ExistenceState> getBy(@NonNull String externalId) {
        return repository
                .findByExternalId(externalId, EdgeSide.ExistenceState.class)
                .map(mapper::toDomain);
    }

    @Override
    public Optional<ServerSide.PreviewState> getBy(@NonNull UUID internalId) {
        return repository
                .findByInternalId(internalId.toString(), EdgeSide.PreviewState.class)
                .map(mapper::toDomain);
    }

    @Override
    public void updateBy(ServerSide.TouchState state, UUID internalId) {
        var stateEdge = mapper.toEdge(state);
        var matchedCount = repository.updateBy(stateEdge, internalId.toString());
        if (matchedCount == 0) {
            throw new ContentionException();
        }
    }
}
