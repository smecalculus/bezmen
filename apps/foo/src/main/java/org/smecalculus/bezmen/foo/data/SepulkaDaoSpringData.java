package org.smecalculus.bezmen.foo.data;

import lombok.NonNull;
import org.smecalculus.bezmen.foo.data.springdata.SepulkaRepository;
import org.smecalculus.bezmen.foo.service.Sepulka;

import java.util.List;
import java.util.UUID;

import static java.util.Collections.emptyList;

public record SepulkaDaoSpringData(
        @NonNull SepulkaRecMapper mapper,
        @NonNull SepulkaRepository repository
) implements SepulkaDao {

    @Override
    public Sepulka getById(@NonNull UUID id) {
        return repository.findById(id.toString())
                .map(mapper::toDomain)
                .orElse(null);
    }

    @Override
    public Sepulka save(@NonNull Sepulka sepulka) {
        SepulkaRec newSepulkaRec = mapper.toRec(sepulka);
        SepulkaRec savedSepulkaRec = repository.save(newSepulkaRec);
        return mapper.toDomain(savedSepulkaRec);
    }

    @Override
    public List<Sepulka> getSepulkas() {
        return emptyList();
    }
}
