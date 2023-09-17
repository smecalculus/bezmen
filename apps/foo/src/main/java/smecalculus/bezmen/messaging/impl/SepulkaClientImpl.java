package smecalculus.bezmen.messaging.impl;

import lombok.NonNull;
import smecalculus.bezmen.domain.spec.Sepulka;
import smecalculus.bezmen.domain.spec.SepulkaConverter;
import smecalculus.bezmen.messaging.spec.SepulkaClient;
import smecalculus.bezmen.messaging.spec.SepulkaRegReq;
import smecalculus.bezmen.messaging.spec.SepulkaRegRes;
import smecalculus.bezmen.validation.spec.BezmenValidator;

public record SepulkaClientImpl(
        @NonNull BezmenValidator validator, @NonNull SepulkaService1 service, @NonNull SepulkaConverter converter)
        implements SepulkaClient {

    @Override
    public SepulkaRegRes register(SepulkaRegReq request) {
        validator.validate(request);
        Sepulka sepulka = service.register(request);
        return converter.toRegRes(sepulka);
    }
}
