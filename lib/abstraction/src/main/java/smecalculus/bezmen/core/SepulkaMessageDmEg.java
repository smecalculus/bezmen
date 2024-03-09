package smecalculus.bezmen.core;

import java.util.UUID;
import smecalculus.bezmen.core.SepulkaMessageDm.RegistrationResponse;
import smecalculus.bezmen.core.SepulkaMessageDm.ViewResponse;

public class SepulkaMessageDmEg {
    public static RegistrationResponse.Builder registrationResponse() {
        return RegistrationResponse.builder().internalId(UUID.randomUUID());
    }

    public static RegistrationResponse.Builder registrationResponse(UUID id) {
        return registrationResponse().internalId(id);
    }

    public static ViewResponse.Builder viewResponse() {
        return ViewResponse.builder().externalId(UUID.randomUUID().toString());
    }

    public static ViewResponse.Builder viewResponse(String id) {
        return viewResponse().externalId(id);
    }
}
