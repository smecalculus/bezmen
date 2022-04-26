package org.smecalculus.bezmen.service;

import lombok.RequiredArgsConstructor;
import org.smecalculus.bezmen.core.Weighing;
import org.smecalculus.bezmen.core.WeighingSpec;
import org.smecalculus.bezmen.data.contract.WeighingDao;
import org.smecalculus.bezmen.service.contract.WeighingService;

import java.util.List;

import static java.util.UUID.randomUUID;

@RequiredArgsConstructor
public class WeighingServiceImpl implements WeighingService {

    private final WeighingDao weighingDao;

    @Override
    public Weighing register(WeighingSpec weighingSpec) {
        Weighing weighing = Weighing.builder().id(randomUUID()).build();
        return weighingDao.save(weighing);
    }

    @Override
    public List<Weighing> getWeighings() {
        return weighingDao.getWeighings();
    }
}
