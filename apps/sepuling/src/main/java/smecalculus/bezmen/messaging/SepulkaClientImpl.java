package smecalculus.bezmen.messaging;

import lombok.NonNull;
import smecalculus.bezmen.core.Sepulka;
import smecalculus.bezmen.core.SepulkaService;
import smecalculus.bezmen.core.SepulkaSliceMapper;
import smecalculus.bezmen.messaging.client.SepulkaClient;
import smecalculus.bezmen.messaging.client.SepulkaRegisterSlice;
import smecalculus.bezmen.messaging.client.SepulkaRegisteredSlice;

public record SepulkaClientImpl(@NonNull SepulkaService service, @NonNull SepulkaSliceMapper mapper)
        implements SepulkaClient {

    @Override
    public SepulkaRegisteredSlice register(SepulkaRegisterSlice command) {
        Sepulka sepulka = service.register(command);
        return mapper.toSlice(sepulka);
    }
}
