package org.smecalculus.bezmen.foo.messaging;

import org.smecalculus.bezmen.client.WeighingRm;
import org.smecalculus.bezmen.client.WeighingSpecRm;

import java.util.List;

public interface WeighingApi {

    WeighingRm register(WeighingSpecRm weighingSpecRm);

    List<WeighingRm> getWeighings();

    List<WeighingRm> register(List<WeighingSpecRm> weighingSpecRms);
}
