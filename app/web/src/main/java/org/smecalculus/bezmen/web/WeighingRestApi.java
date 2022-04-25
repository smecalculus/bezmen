package org.smecalculus.bezmen.web;

import lombok.RequiredArgsConstructor;
import org.smecalculus.bezmen.api.WeighingRm;
import org.smecalculus.bezmen.api.WeighingSpecRm;
import org.smecalculus.bezmen.core.RmMapper;
import org.smecalculus.bezmen.core.weighing.Weighing;
import org.smecalculus.bezmen.core.weighing.WeighingApi;
import org.smecalculus.bezmen.core.weighing.WeighingService;
import org.smecalculus.bezmen.core.weighing.WeighingSpec;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class WeighingRestApi implements WeighingApi {

    private final RmMapper rmMapper;
    private final WeighingService weighingService;

    @Override
    public WeighingRm register(WeighingSpecRm weighingSpecRm) {
        WeighingSpec weighingSpec = rmMapper.map(weighingSpecRm);
        Weighing weighing = weighingService.register(weighingSpec);
        return rmMapper.map(weighing);
    }

    @Override
    public List<WeighingRm> getWeighings() {
        List<Weighing> weighings = weighingService.getWeighings();
        return rmMapper.map(weighings);
    }
}
