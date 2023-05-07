package org.smecalculus.bezmen.data;

import lombok.NonNull;
import org.smecalculus.bezmen.data.springdata.SepulkaRepository;
import org.smecalculus.bezmen.modeling.Sepulka;

import java.util.List;
import java.util.UUID;

import static java.util.stream.Collectors.toList;
import static java.util.stream.StreamSupport.stream;

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
        return stream(repository.findAll().spliterator(), false)
                .map(mapper::toDomain)
                .collect(toList());
    }
}
