package org.smecalculus.bezmen.data.impl;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.UUID;
import lombok.NonNull;
import org.smecalculus.bezmen.data.spec.SepulkaDao;
import org.smecalculus.bezmen.data.spec.SepulkaRec;
import org.smecalculus.bezmen.data.spec.SepulkaRecMapper;
import org.smecalculus.bezmen.data.spec.mybatis.SepulkaSqlMapper;
import org.smecalculus.bezmen.service.spec.Sepulka;

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
