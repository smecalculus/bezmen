package org.smecalculus.bezmen.data;

import lombok.RequiredArgsConstructor;
import org.smecalculus.bezmen.core.DmMapper;
import org.smecalculus.bezmen.core.weighing.Weighing;
import org.smecalculus.bezmen.core.weighing.WeighingDao;
import org.smecalculus.bezmen.core.weighing.WeighingDm;

import java.util.List;

@RequiredArgsConstructor
public class WeighingDaoImpl implements WeighingDao {

    private final DmMapper dmMapper;
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
