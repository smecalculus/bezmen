package smecalculus.bezmen.core;

import java.util.UUID;
import smecalculus.bezmen.core.SepulkaMessageDm.RegistrationResponse;
import smecalculus.bezmen.core.SepulkaMessageDm.ViewingResponse;

public class SepulkaMessageDmEg {
    public static RegistrationResponse.Builder registrationResponse() {
        return RegistrationResponse.builder().internalId(UUID.randomUUID());
    }

    public static RegistrationResponse.Builder registrationResponse(UUID id) {
        return registrationResponse().internalId(id);
    }

    public static ViewingResponse.Builder viewingResponse() {
        return ViewingResponse.builder()
                .externalId(UUID.randomUUID().toString());
    }

    public static ViewingResponse.Builder viewingResponse(String id) {
        return viewingResponse().externalId(id);
    }
}
