package org.smecalculus.bezmen.service.contract;

import org.smecalculus.bezmen.core.service.Weighing;
import org.smecalculus.bezmen.core.service.WeighingSpec;

import java.util.List;

public interface WeighingService {
    Weighing register(WeighingSpec weighingSpec);

    List<Weighing> getWeighings();
}
