package org.smecalculus.bezmen.core;

import org.mapstruct.Mapper;
import org.smecalculus.bezmen.api.WeighingRm;
import org.smecalculus.bezmen.api.WeighingSpecRm;
import org.smecalculus.bezmen.core.weighing.Weighing;
import org.smecalculus.bezmen.core.weighing.WeighingSpec;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RmMapper {

    WeighingSpec map(WeighingSpecRm weighingSpecRm);

    WeighingRm map(Weighing weighing);

    List<WeighingRm> map(List<Weighing> weighings);
}
