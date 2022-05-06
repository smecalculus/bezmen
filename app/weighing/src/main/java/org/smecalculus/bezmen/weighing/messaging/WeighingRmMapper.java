package org.smecalculus.bezmen.weighing.messaging;

import org.mapstruct.Mapper;
import org.smecalculus.bezmen.api.WeighingRm;
import org.smecalculus.bezmen.api.WeighingSpecRm;
import org.smecalculus.bezmen.weighing.service.Weighing;
import org.smecalculus.bezmen.weighing.service.WeighingSpec;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WeighingRmMapper {

    WeighingSpec from(WeighingSpecRm weighingSpecRm);

    WeighingRm from(Weighing weighing);

    List<WeighingRm> from(List<Weighing> weighings);
}
