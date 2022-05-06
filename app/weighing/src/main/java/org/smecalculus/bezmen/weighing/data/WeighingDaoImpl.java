package org.smecalculus.bezmen.weighing.data;

import lombok.RequiredArgsConstructor;
import org.smecalculus.bezmen.weighing.service.Weighing;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class WeighingDaoImpl implements WeighingDao {

    private final WeighingDmMapper dmMapper;
    private final WeighingRepository weighingRepository;

    @Override
    public Weighing save(Weighing weighing) {
        WeighingDm newWeighingDm = dmMapper.map(weighing);
        WeighingDm savedWeighingDm = weighingRepository.save(newWeighingDm);
        return dmMapper.map(savedWeighingDm);
    }

    @Override
    public List<Weighing> getWeighings() {
        Iterable<WeighingDm> weighingDms = weighingRepository.findAll();
        return dmMapper.map(weighingDms);
    }
}
