package org.smecalculus.bezmen.service.contract;

import org.smecalculus.bezmen.core.Weighing;
import org.smecalculus.bezmen.core.WeighingSpec;

import java.util.List;

public interface WeighingService {
    Weighing register(WeighingSpec weighingSpec);

    List<Weighing> getWeighings();
}
