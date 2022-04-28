package org.smecalculus.bezmen.data.impl;

import org.smecalculus.bezmen.data.model.WeighingDm;
import org.smecalculus.bezmen.data.model.WeighingKey;
import org.springframework.data.repository.CrudRepository;

public interface WeighingRepository extends CrudRepository<WeighingDm, WeighingKey> {
}
