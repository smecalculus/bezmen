package smecalculus.bezmen.core;

import java.util.UUID;
import smecalculus.bezmen.core.SepulkaMessageDm.RegistrationResponse;
import smecalculus.bezmen.core.SepulkaMessageDm.ViewResponse;

public class SepulkaMessageDmEg {
    public static RegistrationResponse.Builder registrationResponse() {
        return RegistrationResponse.builder().externalId(UUID.randomUUID().toString());
    }

    public static RegistrationResponse.Builder registrationResponse(String externalId) {
        return registrationResponse().externalId(externalId);
    }

    public static ViewResponse.Builder viewResponse() {
        return ViewResponse.builder().externalId(UUID.randomUUID().toString());
    }

    public static ViewResponse.Builder viewResponse(String externalId) {
        return viewResponse().externalId(externalId);
    }
}
