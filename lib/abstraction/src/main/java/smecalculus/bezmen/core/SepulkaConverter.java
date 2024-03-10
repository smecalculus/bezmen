package smecalculus.bezmen.core;

import org.mapstruct.Mapper;
import smecalculus.bezmen.core.SepulkaMessageDm.RegistrationRequest;
import smecalculus.bezmen.core.SepulkaMessageDm.RegistrationResponse;
import smecalculus.bezmen.core.SepulkaMessageDm.ViewResponse;
import smecalculus.bezmen.core.SepulkaStateDm.AggregateRoot;
import smecalculus.bezmen.core.SepulkaStateDm.Viewing;

@Mapper
public interface SepulkaConverter {
    AggregateRoot.Builder toState(RegistrationRequest request);

    RegistrationResponse toMessage(AggregateRoot state);

    ViewResponse toMessage(Viewing state);
}
