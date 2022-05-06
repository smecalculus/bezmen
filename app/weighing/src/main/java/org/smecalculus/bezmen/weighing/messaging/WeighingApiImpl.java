package org.smecalculus.bezmen.weighing.messaging;

import lombok.NonNull;
import org.smecalculus.bezmen.api.WeighingRm;
import org.smecalculus.bezmen.api.WeighingSpecRm;
import org.smecalculus.bezmen.core.validation.BezmenValidator;
import org.smecalculus.bezmen.weighing.WeighingMapper;
import org.smecalculus.bezmen.weighing.service.Weighing;
import org.smecalculus.bezmen.weighing.service.WeighingService;
import org.smecalculus.bezmen.weighing.service.WeighingSpec;

import java.util.List;

import static java.util.Collections.emptyList;

public record WeighingApiImpl(
        @NonNull WeighingService weighingService,
        @NonNull WeighingMapper mapper,
        @NonNull BezmenValidator validator
) implements WeighingApi {

    @Override
    public WeighingRm register(@NonNull WeighingSpecRm weighingSpecRm) {
        validator.validate(weighingSpecRm);
        WeighingSpec weighingSpec = mapper.from(weighingSpecRm);
        Weighing weighing = weighingService.register(weighingSpec);
        return mapper.from(weighing);
    }

    @Override
    public List<WeighingRm> getWeighings() {
        List<Weighing> weighings = weighingService.getWeighings();
        return mapper.from(weighings);
    }

    @Override
    public List<WeighingRm> register(@NonNull List<WeighingSpecRm> weighingSpecRms) {
        return emptyList();
    }
}
