package org.smecalculus.bezmen.weighing.data;

import lombok.NonNull;
import org.smecalculus.bezmen.weighing.WeighingModelMapper;
import org.smecalculus.bezmen.weighing.data.springdata.WeighingRepository;
import org.smecalculus.bezmen.weighing.service.Weighing;

import java.util.List;
import java.util.UUID;

public record WeighingDaoSpringDataImpl(
        @NonNull WeighingModelMapper mapper,
        @NonNull WeighingRepository repository
) implements WeighingDao {

    @Override
    public Weighing getById(@NonNull UUID id) {
        return repository.findById(id.toString())
                .map(mapper::from)
                .orElse(null);
    }

    @Override
    public Weighing save(@NonNull Weighing weighing) {
        WeighingDm newWeighingDm = mapper.toDm(weighing);
        WeighingDm savedWeighingDm = repository.save(newWeighingDm);
        return mapper.from(savedWeighingDm);
    }

    @Override
    public List<Weighing> getWeighings() {
        Iterable<WeighingDm> weighingDms = repository.findAll();
        return mapper.from(weighingDms);
    }
}
