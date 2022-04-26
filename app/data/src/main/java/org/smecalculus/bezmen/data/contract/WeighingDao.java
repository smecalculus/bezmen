package org.smecalculus.bezmen.data.contract;

import org.smecalculus.bezmen.core.Weighing;

import java.util.List;

public interface WeighingDao {
    Weighing save(Weighing weighing);

    List<Weighing> getWeighings();
}
