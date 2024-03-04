package smecalculus.bezmen.messaging;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import smecalculus.bezmen.core.SepulkaService;
import smecalculus.bezmen.messaging.SepulkaMessageEm.RegistrationRequest;
import smecalculus.bezmen.messaging.SepulkaMessageEm.RegistrationResponse;
import smecalculus.bezmen.messaging.SepulkaMessageEm.ViewRequest;
import smecalculus.bezmen.messaging.SepulkaMessageEm.ViewResponse;
import smecalculus.bezmen.validation.EdgeValidator;

@RequiredArgsConstructor
public class SepulkaClientImpl implements SepulkaClient {

    @NonNull
    private EdgeValidator validator;

    @NonNull
    private SepulkaMessageMapper mapper;

    @NonNull
    private SepulkaService service;

    @Override
    public RegistrationResponse register(RegistrationRequest requestEdge) {
        validator.validate(requestEdge);
        var request = mapper.toDomain(requestEdge);
        var response = service.register(request);
        return mapper.toEdge(response);
    }

    @Override
    public ViewResponse view(ViewRequest requestEdge) {
        validator.validate(requestEdge);
        var request = mapper.toDomain(requestEdge);
        var response = service.view(request);
        return mapper.toEdge(response);
    }
}
