package smecalculus.bezmen.messaging;

import lombok.NonNull;
import smecalculus.bezmen.core.Sepulka;
import smecalculus.bezmen.core.SepulkaConverter;
import smecalculus.bezmen.core.SepulkaService;
import smecalculus.bezmen.messaging.client.SepulkaClient;
import smecalculus.bezmen.messaging.client.SepulkaRegReq;
import smecalculus.bezmen.messaging.client.SepulkaRegRes;

public record SepulkaClientImpl(@NonNull SepulkaService service, @NonNull SepulkaConverter converter)
        implements SepulkaClient {

    @Override
    public SepulkaRegRes register(SepulkaRegReq request) {
        Sepulka sepulka = service.register(request);
        return converter.toRegRes(sepulka);
    }
}
