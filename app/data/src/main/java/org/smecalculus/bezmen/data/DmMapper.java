package org.smecalculus.bezmen.data;

import org.mapstruct.Mapper;
import org.smecalculus.bezmen.core.Weighing;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring")
public interface DmMapper {

    WeighingDm map(Weighing weighing);

    Weighing map(WeighingDm weighingDm);

    List<Weighing> map(Iterable<WeighingDm> weighingDms);

    String map(UUID uuid);

    UUID map(String uuid);
}
