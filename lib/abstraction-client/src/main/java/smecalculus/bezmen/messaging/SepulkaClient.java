package smecalculus.bezmen.messaging;

import smecalculus.bezmen.messaging.SepulkaMessageEm.RegistrationRequest;
import smecalculus.bezmen.messaging.SepulkaMessageEm.RegistrationResponse;
import smecalculus.bezmen.messaging.SepulkaMessageEm.ViewRequest;
import smecalculus.bezmen.messaging.SepulkaMessageEm.ViewResponse;

/**
 * Port: client side
 */
public interface SepulkaClient {
    RegistrationResponse register(RegistrationRequest request);

    ViewResponse view(ViewRequest request);
}
