package org.smecalculus.bezmen.weighing.service;

import lombok.RequiredArgsConstructor;
import org.smecalculus.bezmen.weighing.data.WeighingDao;

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
