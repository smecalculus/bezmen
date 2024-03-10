package smecalculus.bezmen.core;

import smecalculus.bezmen.core.SepulkaMessageDm.RegistrationRequest;
import smecalculus.bezmen.core.SepulkaMessageDm.RegistrationResponse;
import smecalculus.bezmen.core.SepulkaMessageDm.ViewingRequest;

public interface SepulkaService {
    RegistrationResponse register(RegistrationRequest request);

    SepulkaMessageDm.ViewingResponse view(ViewingRequest request);
}
