package org.smecalculus.bezmen.weighing.messaging;

import org.smecalculus.bezmen.api.WeighingRm;
import org.smecalculus.bezmen.api.WeighingSpecRm;

import java.util.List;

public interface WeighingApi {

    WeighingRm register(WeighingSpecRm weighingSpecRm);

    List<WeighingRm> getWeighings();

    List<WeighingRm> register(List<WeighingSpecRm> weighingSpecRms);
}
