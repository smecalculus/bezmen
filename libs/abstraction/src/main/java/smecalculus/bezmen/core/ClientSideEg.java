package smecalculus.bezmen.core;

import java.util.UUID;
import smecalculus.bezmen.core.ClientSide.RegistrationResponse;

public class ClientSideEg {
    public static RegistrationResponse.Builder registrationResponse() {
        return RegistrationResponse.builder().externalId(UUID.randomUUID().toString());
    }

    public static RegistrationResponse.Builder registrationResponse(String externalId) {
        return registrationResponse().externalId(externalId);
    }
}
