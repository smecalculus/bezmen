package org.smecalculus.bezmen.weighing;

import org.mapstruct.Mapper;
import org.smecalculus.bezmen.api.WeighingRm;
import org.smecalculus.bezmen.api.WeighingSpecRm;
import org.smecalculus.bezmen.weighing.data.WeighingDm;
import org.smecalculus.bezmen.weighing.service.Weighing;
import org.smecalculus.bezmen.weighing.service.WeighingSpec;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring")
public interface WeighingMapper {

    WeighingSpec from(WeighingSpecRm weighingSpecRm);

    WeighingRm from(Weighing weighing);

    List<WeighingRm> from(List<Weighing> weighings);

    WeighingDm map(Weighing weighing);

    Weighing map(WeighingDm weighingDm);

    List<Weighing> map(Iterable<WeighingDm> weighingDms);

    String map(UUID uuid);

    UUID map(String uuid);
}
