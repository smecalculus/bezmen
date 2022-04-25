package org.smecalculus.bezmen.data;

import org.smecalculus.bezmen.core.weighing.WeighingDm;
import org.springframework.data.repository.CrudRepository;

public interface WeighingRepository extends CrudRepository<WeighingDm, WeighingKey> {
}
