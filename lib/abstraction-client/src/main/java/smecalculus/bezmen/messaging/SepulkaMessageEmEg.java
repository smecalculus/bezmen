package smecalculus.bezmen.messaging;

import java.util.UUID;
import smecalculus.bezmen.messaging.SepulkaMessageEm.RegistrationRequest;
import smecalculus.bezmen.messaging.SepulkaMessageEm.RegistrationResponse;
import smecalculus.bezmen.messaging.SepulkaMessageEm.ViewRequest;
import smecalculus.bezmen.messaging.SepulkaMessageEm.ViewResponse;

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

    public static ViewRequest viewRequest() {
        var requestEdge = new ViewRequest();
        requestEdge.setInternalId(UUID.randomUUID().toString());
        return requestEdge;
    }

    public static ViewRequest viewRequest(String id) {
        var requestEdge = viewRequest();
        requestEdge.setInternalId(id);
        return requestEdge;
    }

    public static ViewResponse viewResponse() {
        var responseEdge = new ViewResponse();
        responseEdge.setExternalId(UUID.randomUUID().toString());
        return responseEdge;
    }

    public static ViewResponse viewResponse(String externalId) {
        var responseEdge = viewResponse();
        responseEdge.setExternalId(externalId);
        return responseEdge;
    }
}
