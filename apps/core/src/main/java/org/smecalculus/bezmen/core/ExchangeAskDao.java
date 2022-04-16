package org.smecalculus.bezmen.core;

import java.util.List;

public interface ExchangeAskDao {
    List<ExchangeAsk> getByOffset(Long offset);
}
