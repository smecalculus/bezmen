package org.smecalculus.bezmen.data;

import lombok.NonNull;
import org.smecalculus.bezmen.data.mybatis.SepulkaSqlMapper;
import org.smecalculus.bezmen.modeling.Sepulka;

import java.util.List;
import java.util.UUID;

import static java.util.Collections.emptyList;

public record SepulkaDaoMyBatis(
        @NonNull SepulkaRecMapper mapper,
        @NonNull SepulkaSqlMapper sqlMapper
) implements SepulkaDao {

    @Override
    public Sepulka getById(@NonNull UUID id) {
        return sqlMapper.findById(id.toString())
                .map(mapper::toDomain)
                .orElse(null);
    }

    @Override
    public Sepulka save(@NonNull Sepulka sepulka) {
        SepulkaRec newSepulkaRec = mapper.toRec(sepulka);
        sqlMapper.insert(newSepulkaRec);
        return sepulka;
    }

    @Override
    public List<Sepulka> getSepulkas() {
        return emptyList();
    }
}
