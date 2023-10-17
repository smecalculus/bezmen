package smecalculus.bezmen.storage;

import java.util.Optional;
import java.util.UUID;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import smecalculus.bezmen.core.ServerSide.CreationState;
import smecalculus.bezmen.core.ServerSide.PreviewState;
import smecalculus.bezmen.core.ServerSide.StorageState;
import smecalculus.bezmen.core.ServerSide.TouchState;
import smecalculus.bezmen.storage.mybatis.SepulkaSqlMapper;

@RequiredArgsConstructor
public class SepulkaDaoMyBatis implements SepulkaDao {

    @NonNull
    private SepulkaStateMapper stateMapper;

    @NonNull
    private SepulkaSqlMapper sqlMapper;

    @Override
    public StorageState add(@NonNull StorageState state) {
        var stateEdge = stateMapper.toEdge(state);
        sqlMapper.insert(stateEdge);
        return state;
    }

    @Override
    public Optional<CreationState> getBy(@NonNull String externalId) {
        return sqlMapper.findByExternalId(externalId).map(stateMapper::toDomain);
    }

    @Override
    public Optional<PreviewState> getBy(@NonNull UUID internalId) {
        return sqlMapper.findByInternalId(internalId.toString()).map(stateMapper::toDomain);
    }

    @Override
    public void updateBy(TouchState state, UUID internalId) {
        sqlMapper.updateBy(stateMapper.toEdge(state), internalId.toString());
    }
}
