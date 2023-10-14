package smecalculus.bezmen.messaging;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import smecalculus.bezmen.core.SepulkaService;
import smecalculus.bezmen.validation.EdgeValidator;

@RequiredArgsConstructor
public class SepulkaClientImpl implements SepulkaClient {

    @NonNull
    private EdgeValidator validator;

    @NonNull
    private SepulkaMsgMapper mapper;

    @NonNull
    private SepulkaService service;

    @Override
    public SepulkaNewResponseMsg register(SepulkaNewRequestMsg requestMsg) {
        validator.validate(requestMsg);
        var request = mapper.toDomain(requestMsg);
        var response = service.register(request);
        return mapper.toMsg(response);
    }
}
