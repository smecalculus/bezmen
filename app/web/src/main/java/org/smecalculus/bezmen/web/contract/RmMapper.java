package org.smecalculus.bezmen.web.contract;

import org.mapstruct.Mapper;
import org.smecalculus.bezmen.api.WeighingRm;
import org.smecalculus.bezmen.api.WeighingSpecRm;
import org.smecalculus.bezmen.core.service.Weighing;
import org.smecalculus.bezmen.core.service.WeighingSpec;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RmMapper {

    WeighingSpec map(WeighingSpecRm weighingSpecRm);

    WeighingRm map(Weighing weighing);

    List<WeighingRm> map(List<Weighing> weighings);
}
