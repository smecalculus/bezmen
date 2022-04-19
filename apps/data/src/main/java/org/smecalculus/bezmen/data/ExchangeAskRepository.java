package org.smecalculus.bezmen.data;

import org.smecalculus.bezmen.core.ExchangeAsk;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ExchangeAskRepository extends CrudRepository<ExchangeAsk, Long> {

    @Query("SELECT * FROM asks WHERE offset = :offset")
    List<ExchangeAsk> getByOffset(Long offset);
}
