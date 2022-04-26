package org.smecalculus.bezmen.web.contract;

import org.smecalculus.bezmen.api.WeighingRm;
import org.smecalculus.bezmen.api.WeighingSpecRm;

import java.util.List;

public interface WeighingApi {
    WeighingRm register(WeighingSpecRm weighingSpecRm);

    List<WeighingRm> getWeighings();
}
