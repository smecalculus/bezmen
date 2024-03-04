package smecalculus.bezmen.core;

import smecalculus.bezmen.core.SepulkaMessageDm.RegistrationRequest;
import smecalculus.bezmen.core.SepulkaMessageDm.RegistrationResponse;
import smecalculus.bezmen.core.SepulkaMessageDm.ViewRequest;
import smecalculus.bezmen.core.SepulkaMessageDm.ViewResponse;

public interface SepulkaService {
    RegistrationResponse register(RegistrationRequest request);

    ViewResponse view(ViewRequest request);
}
