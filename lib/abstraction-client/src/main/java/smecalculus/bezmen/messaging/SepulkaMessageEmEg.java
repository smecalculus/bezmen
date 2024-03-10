package smecalculus.bezmen.messaging;

import java.util.UUID;
import smecalculus.bezmen.messaging.SepulkaMessageEm.RegistrationRequest;
import smecalculus.bezmen.messaging.SepulkaMessageEm.RegistrationResponse;
import smecalculus.bezmen.messaging.SepulkaMessageEm.ViewingRequest;
import smecalculus.bezmen.messaging.SepulkaMessageEm.ViewingResponse;

public abstract class SepulkaMessageEmEg {
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
        var responseEdge = new RegistrationResponse();
        responseEdge.setInternalId(UUID.randomUUID().toString());
        return responseEdge;
    }

    public static RegistrationResponse registrationResponse(String id) {
        var responseEdge = registrationResponse();
        responseEdge.setInternalId(id);
        return responseEdge;
    }

    public static ViewingRequest viewingRequest() {
        var requestEdge = new ViewingRequest();
        requestEdge.setInternalId(UUID.randomUUID().toString());
        return requestEdge;
    }

    public static ViewingRequest viewingRequest(String id) {
        var requestEdge = viewingRequest();
        requestEdge.setInternalId(id);
        return requestEdge;
    }

    public static ViewingResponse viewingResponse() {
        var responseEdge = new ViewingResponse();
        responseEdge.setExternalId(UUID.randomUUID().toString());
        return responseEdge;
    }

    public static ViewingResponse viewingResponse(String externalId) {
        var responseEdge = viewingResponse();
        responseEdge.setExternalId(externalId);
        return responseEdge;
    }
}
