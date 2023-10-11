package smecalculus.bezmen.interior.storage;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.UUID;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import smecalculus.bezmen.interior.core.Sepulka;
import smecalculus.bezmen.interior.storage.mybatis.SepulkaSqlMapper;

@RequiredArgsConstructor
public class SepulkaDaoMyBatis implements SepulkaDao {

    @NonNull
    private SepulkaRecMapper recMapper;

    @NonNull
    private SepulkaSqlMapper sqlMapper;

    @Override
    public Sepulka getById(@NonNull UUID id) {
        return sqlMapper.findById(id.toString()).map(recMapper::toDomain).orElse(null);
    }

    @Override
    public Sepulka save(@NonNull Sepulka sepulka) {
        SepulkaRec sepulkaRec = recMapper.toRec(sepulka);
        sqlMapper.insert(sepulkaRec);
        return sepulka;
    }

    @Override
    public List<Sepulka> getSepulkas() {
        return sqlMapper.selectAll().stream().map(recMapper::toDomain).collect(toList());
    }
}
