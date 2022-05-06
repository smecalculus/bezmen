package org.smecalculus.bezmen.weighing.data;

import lombok.NonNull;
import org.smecalculus.bezmen.weighing.WeighingMapper;
import org.smecalculus.bezmen.weighing.service.Weighing;

import java.util.List;

public record WeighingDaoImpl(
        @NonNull WeighingMapper mapper,
        @NonNull WeighingRepository repository
) implements WeighingDao {

    @Override
    public Weighing save(@NonNull Weighing weighing) {
        WeighingDm newWeighingDm = mapper.map(weighing);
        WeighingDm savedWeighingDm = repository.save(newWeighingDm);
        return mapper.map(savedWeighingDm);
    }

    @Override
    public List<Weighing> getWeighings() {
        Iterable<WeighingDm> weighingDms = repository.findAll();
        return mapper.map(weighingDms);
    }
}
