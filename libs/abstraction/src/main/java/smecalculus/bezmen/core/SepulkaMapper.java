package smecalculus.bezmen.core;

import org.mapstruct.Mapper;
import smecalculus.bezmen.core.MessageDomain.RegistrationRequest;
import smecalculus.bezmen.core.MessageDomain.RegistrationResponse;
import smecalculus.bezmen.core.StateDomain.AggregateState;

@Mapper
public interface SepulkaMapper {
    AggregateState.Builder toServer(RegistrationRequest request);

    RegistrationResponse.Builder toClient(AggregateState state);
}
