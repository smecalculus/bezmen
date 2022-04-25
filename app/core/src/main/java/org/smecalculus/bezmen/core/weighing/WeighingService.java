package org.smecalculus.bezmen.core.weighing;

import java.util.List;

public interface WeighingService {
    Weighing register(WeighingSpec weighingSpec);

    List<Weighing> getWeighings();
}
