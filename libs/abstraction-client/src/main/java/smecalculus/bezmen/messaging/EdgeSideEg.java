package smecalculus.bezmen.messaging;

import java.util.UUID;
import smecalculus.bezmen.messaging.EdgeSide.RegistrationRequest;
import smecalculus.bezmen.messaging.EdgeSide.RegistrationResponse;

public class EdgeSideEg {

    public static RegistrationRequest registrationRequest() {
        var requestEdge = new RegistrationRequest();
        requestEdge.setExternalId(UUID.randomUUID().toString());
        return requestEdge;
    }

    public static RegistrationRequest registrationRequest(String id) {
        var requestEdge = registrationRequest();
        requestEdge.setExternalId(id);
        return requestEdge;
    }

    public static RegistrationResponse registrationResponse() {
        var responseEdge = new EdgeSide.RegistrationResponse();
        responseEdge.setExternalId(UUID.randomUUID().toString());
        return responseEdge;
    }

    public static EdgeSide.RegistrationResponse registrationResponse(String externalId) {
        var responseEdge = registrationResponse();
        responseEdge.setExternalId(externalId);
        return responseEdge;
    }
}
