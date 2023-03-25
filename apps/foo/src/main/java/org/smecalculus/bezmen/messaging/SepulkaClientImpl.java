package org.smecalculus.bezmen.messaging;

import lombok.NonNull;
import org.smecalculus.bezmen.client.SepulkaClient;
import org.smecalculus.bezmen.client.SepulkaRegReq;
import org.smecalculus.bezmen.client.SepulkaRegRes;
import org.smecalculus.bezmen.domain.Sepulka;
import org.smecalculus.bezmen.domain.SepulkaService;
import org.smecalculus.bezmen.service.SepulkaConverter;
import org.smecalculus.bezmen.validation.BezmenValidator;

public record SepulkaClientImpl(
        @NonNull BezmenValidator validator,
        @NonNull SepulkaService service,
        @NonNull SepulkaConverter converter
) implements SepulkaClient {

    @Override
    public SepulkaRegRes register(SepulkaRegReq request) {
        validator.validate(request);
        Sepulka sepulka = service.register(request);
        return converter.convert(sepulka);
    }
}
