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
    public Optional<ServerSide.CreationState> getBy(@NonNull String externalId) {
        return repository
                .findByExternalId(externalId, EdgeSide.CreationState.class)
                .map(mapper::toDomain);
    }

    @Override
    public Optional<ServerSide.PreviewState> getBy(@NonNull UUID internalId) {
        return repository
                .findByInternalId(internalId.toString(), EdgeSide.PreviewState.class)
                .map(mapper::toDomain);
    }

    @Override
    public int updateBy(ServerSide.TouchState state, UUID internalId) {
        return repository.updateBy(mapper.toEdge(state), internalId.toString());
    }
}
