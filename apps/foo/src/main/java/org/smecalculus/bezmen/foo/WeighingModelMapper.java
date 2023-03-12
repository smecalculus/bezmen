package org.smecalculus.bezmen.foo;

import org.mapstruct.Mapper;
import org.smecalculus.bezmen.api.WeighingRm;
import org.smecalculus.bezmen.api.WeighingSpecRm;
import org.smecalculus.bezmen.foo.data.WeighingDm;
import org.smecalculus.bezmen.foo.service.Weighing;
import org.smecalculus.bezmen.foo.service.WeighingSpec;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WeighingModelMapper {

    WeighingSpec from(WeighingSpecRm weighingSpecRm);

    WeighingRm toRm(Weighing weighing);

    List<WeighingRm> toRm(List<Weighing> weighings);

    WeighingDm toDm(Weighing weighing);

    Weighing from(WeighingDm weighingDm);

    List<Weighing> from(Iterable<WeighingDm> weighingDms);
}
