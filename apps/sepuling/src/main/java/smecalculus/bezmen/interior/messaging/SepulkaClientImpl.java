package smecalculus.bezmen.interior.messaging;

import lombok.NonNull;
import smecalculus.bezmen.exterior.messaging.SepulkaClient;
import smecalculus.bezmen.exterior.messaging.SepulkaRegisterSlice;
import smecalculus.bezmen.exterior.messaging.SepulkaRegisteredSlice;
import smecalculus.bezmen.interior.core.Sepulka;
import smecalculus.bezmen.interior.core.SepulkaService;
import smecalculus.bezmen.interior.core.SepulkaSliceMapper;

public record SepulkaClientImpl(@NonNull SepulkaService service, @NonNull SepulkaSliceMapper mapper)
        implements SepulkaClient {

    @Override
    public SepulkaRegisteredSlice register(SepulkaRegisterSlice request) {
        Sepulka sepulka = service.register(request);
        return mapper.toSlice(sepulka);
    }
}
