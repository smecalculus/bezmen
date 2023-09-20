package smecalculus.bezmen.data.impl;

import static java.util.stream.Collectors.toList;
import static java.util.stream.StreamSupport.stream;

import java.util.List;
import java.util.UUID;
import lombok.NonNull;
import smecalculus.bezmen.data.spec.SepulkaDao;
import smecalculus.bezmen.data.spec.SepulkaRec;
import smecalculus.bezmen.data.spec.SepulkaRecMapper;
import smecalculus.bezmen.data.spec.springdata.SepulkaRepository;
import smecalculus.bezmen.domain.spec.Sepulka;

public record SepulkaDaoSpringData(@NonNull SepulkaRecMapper mapper, @NonNull SepulkaRepository repository)
        implements SepulkaDao {

    @Override
    public Sepulka getById(@NonNull UUID id) {
        return repository.findById(id.toString()).map(mapper::toDomain).orElse(null);
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
