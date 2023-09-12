package org.smecalculus.bezmen.messaging.impl;

import lombok.NonNull;
import org.smecalculus.bezmen.domain.spec.Sepulka;
import org.smecalculus.bezmen.domain.spec.SepulkaConverter;
import org.smecalculus.bezmen.domain.spec.SepulkaService;
import org.smecalculus.bezmen.messaging.spec.SepulkaClient;
import org.smecalculus.bezmen.messaging.spec.SepulkaRegReq;
import org.smecalculus.bezmen.messaging.spec.SepulkaRegRes;
import org.smecalculus.bezmen.validation.spec.BezmenValidator;

public record SepulkaClientImpl(
        @NonNull BezmenValidator validator, @NonNull SepulkaService service, @NonNull SepulkaConverter converter)
        implements SepulkaClient {

    @Override
    public SepulkaRegRes register(SepulkaRegReq request) {
        validator.validate(request);
        Sepulka sepulka = service.register(request);
        return converter.toRegRes(sepulka);
    }
}
