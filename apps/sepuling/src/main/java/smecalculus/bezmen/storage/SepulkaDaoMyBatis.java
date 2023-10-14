package smecalculus.bezmen.storage;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.UUID;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import smecalculus.bezmen.core.Sepulka;
import smecalculus.bezmen.storage.mybatis.SepulkaSqlMapper;

@RequiredArgsConstructor
public class SepulkaDaoMyBatis implements SepulkaDao {

    @NonNull
    private SepulkaStateMapper stateMapper;

    @NonNull
    private SepulkaSqlMapper sqlMapper;

    @Override
    public Sepulka getById(@NonNull UUID id) {
        return sqlMapper.findById(id.toString()).map(stateMapper::toDomain).orElse(null);
    }

    @Override
    public Sepulka save(@NonNull Sepulka sepulka) {
        var sepulkaEdge = stateMapper.toEdge(sepulka);
        sqlMapper.insert(sepulkaEdge);
        return sepulka;
    }

    @Override
    public List<Sepulka> getSepulkas() {
        return sqlMapper.selectAll().stream().map(stateMapper::toDomain).collect(toList());
    }
}
