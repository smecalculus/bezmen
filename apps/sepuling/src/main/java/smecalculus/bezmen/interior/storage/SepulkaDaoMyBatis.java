package smecalculus.bezmen.interior.storage;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.UUID;
import lombok.NonNull;
import smecalculus.bezmen.interior.core.Sepulka;
import smecalculus.bezmen.interior.storage.mybatis.SepulkaSqlMapper;

public record SepulkaDaoMyBatis(@NonNull SepulkaRecMapper recMapper, @NonNull SepulkaSqlMapper sqlMapper)
        implements SepulkaDao {

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
