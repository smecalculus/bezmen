package smecalculus.bezmen.interior.storage;

import static java.util.stream.Collectors.toList;
import static java.util.stream.StreamSupport.stream;

import java.util.List;
import java.util.UUID;
import lombok.NonNull;
import smecalculus.bezmen.interior.core.Sepulka;
import smecalculus.bezmen.interior.storage.springdata.SepulkaRepository;

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
