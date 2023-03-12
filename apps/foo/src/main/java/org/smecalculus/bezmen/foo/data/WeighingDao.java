package org.smecalculus.bezmen.foo.data;

import org.smecalculus.bezmen.foo.service.Weighing;

import java.util.List;
import java.util.UUID;

public interface WeighingDao {

    Weighing getById(UUID id);

    Weighing save(Weighing weighing);

    List<Weighing> getWeighings();
}
