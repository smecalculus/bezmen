package smecalculus.bezmen.interior.messaging;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import smecalculus.bezmen.exterior.messaging.SepulkaClient;
import smecalculus.bezmen.exterior.messaging.SepulkaMsgMapper;
import smecalculus.bezmen.exterior.messaging.SepulkaRegisterSliceMsg;
import smecalculus.bezmen.exterior.messaging.SepulkaRegisteredSliceMsg;
import smecalculus.bezmen.interior.core.SepulkaService;
import smecalculus.bezmen.interior.validation.EdgeValidator;

@RequiredArgsConstructor
public class SepulkaClientImpl implements SepulkaClient {

    @NonNull
    private EdgeValidator validator;

    @NonNull
    private SepulkaMsgMapper mapper;

    @NonNull
    private SepulkaService service;

    @Override
    public SepulkaRegisteredSliceMsg register(SepulkaRegisterSliceMsg sliceMsg) {
        validator.validate(sliceMsg);
        var registerSlice = mapper.toDomain(sliceMsg);
        var registeredSlice = service.register(registerSlice);
        return mapper.toMsg(registeredSlice);
    }
}
