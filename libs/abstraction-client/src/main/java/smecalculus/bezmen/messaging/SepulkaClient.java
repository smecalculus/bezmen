package smecalculus.bezmen.messaging;

import smecalculus.bezmen.messaging.EdgeSide.RegistrationRequest;
import smecalculus.bezmen.messaging.EdgeSide.RegistrationResponse;

/**
 * Port: client side
 */
public interface SepulkaClient {
    RegistrationResponse register(RegistrationRequest request);
}
