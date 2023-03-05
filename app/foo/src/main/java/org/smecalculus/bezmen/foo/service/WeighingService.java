package org.smecalculus.bezmen.foo.service;

import java.util.List;

public interface WeighingService {
    Weighing register(WeighingSpec weighingSpec);

    List<Weighing> getWeighings();
}
