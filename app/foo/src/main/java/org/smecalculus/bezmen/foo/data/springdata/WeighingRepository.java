package org.smecalculus.bezmen.foo.data.springdata;

import org.smecalculus.bezmen.foo.data.WeighingDm;
import org.springframework.data.repository.CrudRepository;

public interface WeighingRepository extends CrudRepository<WeighingDm, String> {
}
