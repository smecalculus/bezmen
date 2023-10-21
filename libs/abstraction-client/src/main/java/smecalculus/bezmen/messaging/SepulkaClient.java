package smecalculus.bezmen.messaging;

import smecalculus.bezmen.messaging.MessageEdge.RegistrationRequest;
import smecalculus.bezmen.messaging.MessageEdge.RegistrationResponse;

/**
 * Port: client side
 */
public interface SepulkaClient {
    RegistrationResponse register(RegistrationRequest request);
}
