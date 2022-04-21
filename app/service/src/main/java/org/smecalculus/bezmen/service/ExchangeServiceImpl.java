package org.smecalculus.bezmen.service;

import lombok.RequiredArgsConstructor;
import org.smecalculus.bezmen.core.ExchangeAskDao;
import org.smecalculus.bezmen.core.ExchangeService;

@RequiredArgsConstructor
public class ExchangeServiceImpl implements ExchangeService {
    private final ExchangeAskDao exchangeAskDao;
}
