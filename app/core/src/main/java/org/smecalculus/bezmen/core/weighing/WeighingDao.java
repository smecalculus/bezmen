package org.smecalculus.bezmen.core.weighing;

import java.util.List;

public interface WeighingDao {
    Weighing save(Weighing weighing);

    List<Weighing> getWeighings();
}
