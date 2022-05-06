package org.smecalculus.bezmen.weighing.data;

import org.smecalculus.bezmen.weighing.service.Weighing;

import java.util.List;

public interface WeighingDao {
    Weighing save(Weighing weighing);

    List<Weighing> getWeighings();
}
