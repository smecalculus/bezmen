package smecalculus.bezmen.core;

import java.util.List;
import smecalculus.bezmen.core.ClientSide.PreviewRequest;
import smecalculus.bezmen.core.ClientSide.PreviewResponse;
import smecalculus.bezmen.core.ClientSide.RegistrationRequest;
import smecalculus.bezmen.core.ClientSide.RegistrationResponse;

public interface SepulkaService {
    RegistrationResponse register(RegistrationRequest request);

    List<PreviewResponse> view(PreviewRequest request);
}
