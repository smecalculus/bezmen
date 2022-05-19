package org.smecalculus.bezmen.weighing.data.springdata;

import org.smecalculus.bezmen.weighing.data.WeighingDm;
import org.springframework.data.repository.CrudRepository;

public interface WeighingRepository extends CrudRepository<WeighingDm, String> {
}
