package org.smecalculus.bezmen.ingestion;

import lombok.RequiredArgsConstructor;
import org.smecalculus.bezmen.core.ExchangeConsumer;
import org.smecalculus.bezmen.core.ExchangeService;

@RequiredArgsConstructor
public class ExchangeConsumerImpl implements ExchangeConsumer {
    private final ExchangeService exchangeService;
}
