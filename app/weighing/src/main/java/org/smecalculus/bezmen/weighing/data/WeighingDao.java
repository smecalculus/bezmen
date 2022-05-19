package org.smecalculus.bezmen.weighing.data;

import org.smecalculus.bezmen.weighing.service.Weighing;

import java.util.List;
import java.util.UUID;

public interface WeighingDao {

    Weighing getById(UUID id);

    Weighing save(Weighing weighing);

    List<Weighing> getWeighings();
}
