package org.smecalculus.bezmen.foo.service;

import lombok.NonNull;
import org.smecalculus.bezmen.foo.data.WeighingDao;

import java.util.List;

import static java.util.UUID.randomUUID;

public record WeighingServiceImpl(
        @NonNull WeighingDao weighingDao
) implements WeighingService {

    @Override
    public Weighing register(@NonNull WeighingSpec weighingSpec) {
        Weighing weighing = Weighing.builder().id(randomUUID()).build();
        return weighingDao.save(weighing);
    }

    @Override
    public List<Weighing> getWeighings() {
        return weighingDao.getWeighings();
    }
}
