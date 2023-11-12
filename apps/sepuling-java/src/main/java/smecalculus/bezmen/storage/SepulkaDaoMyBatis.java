package smecalculus.bezmen.storage;

import java.util.Optional;
import java.util.UUID;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import smecalculus.bezmen.core.StateDm;
import smecalculus.bezmen.storage.mybatis.SepulkaSqlMapper;

@RequiredArgsConstructor
public class SepulkaDaoMyBatis implements SepulkaDao {

    @NonNull
    private SepulkaStateMapper stateMapper;

    @NonNull
    private SepulkaSqlMapper sqlMapper;

    @Override
    public StateDm.AggregateRoot add(@NonNull StateDm.AggregateRoot state) {
        var stateEdge = stateMapper.toEdge(state);
        sqlMapper.insert(stateEdge);
        return state;
    }

    @Override
    public Optional<StateDm.Existence> getBy(@NonNull String externalId) {
        return sqlMapper.findByExternalId(externalId).map(stateMapper::toDomain);
    }

    @Override
    public Optional<StateDm.Preview> getBy(@NonNull UUID internalId) {
        return sqlMapper.findByInternalId(internalId.toString()).map(stateMapper::toDomain);
    }

    @Override
    public void updateBy(StateDm.Touch state, UUID internalId) {
        var stateEdge = stateMapper.toEdge(state);
        var matchedCount = sqlMapper.updateBy(stateEdge, internalId.toString());
        if (matchedCount == 0) {
            throw new ContentionException();
        }
    }
}
