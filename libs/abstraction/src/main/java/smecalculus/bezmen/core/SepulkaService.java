package smecalculus.bezmen.core;

import java.util.List;
import smecalculus.bezmen.core.MessageDomain.PreviewRequest;
import smecalculus.bezmen.core.MessageDomain.PreviewResponse;
import smecalculus.bezmen.core.MessageDomain.RegistrationRequest;
import smecalculus.bezmen.core.MessageDomain.RegistrationResponse;

public interface SepulkaService {
    RegistrationResponse register(RegistrationRequest request);

    List<PreviewResponse> view(PreviewRequest request);
}
