package org.smecalculus.bezmen.data;

import lombok.RequiredArgsConstructor;
import org.smecalculus.bezmen.core.ExchangeAsk;
import org.smecalculus.bezmen.core.ExchangeAskDao;

import java.util.List;

@RequiredArgsConstructor
public class ExchangeAskDaoImpl implements ExchangeAskDao {
    private final ExchangeAskRepository exchangeAskRepository;
    private final ExchangeAskSqlMapper exchangeAskSqlMapper;

    @Override
    public List<ExchangeAsk> getByOffset(Long offset) {
        return null;
    }
}
