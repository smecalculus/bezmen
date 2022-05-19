package org.smecalculus.bezmen.weighing;

import org.mapstruct.Mapper;
import org.smecalculus.bezmen.api.WeighingRm;
import org.smecalculus.bezmen.api.WeighingSpecRm;
import org.smecalculus.bezmen.weighing.data.WeighingDm;
import org.smecalculus.bezmen.weighing.service.Weighing;
import org.smecalculus.bezmen.weighing.service.WeighingSpec;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WeighingMapper {

    WeighingSpec from(WeighingSpecRm weighingSpecRm);

    WeighingRm toRm(Weighing weighing);

    List<WeighingRm> toRm(List<Weighing> weighings);

    WeighingDm toDm(Weighing weighing);

    Weighing from(WeighingDm weighingDm);

    List<Weighing> from(Iterable<WeighingDm> weighingDms);
}
