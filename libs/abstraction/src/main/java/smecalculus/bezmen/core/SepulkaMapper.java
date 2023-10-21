package smecalculus.bezmen.core;

import org.mapstruct.Mapper;
import smecalculus.bezmen.core.MessageDomain.RegistrationRequest;
import smecalculus.bezmen.core.MessageDomain.RegistrationResponse;
import smecalculus.bezmen.core.StateDomain.AggregateState;

@Mapper
public interface SepulkaMapper {
    AggregateState.Builder toState(RegistrationRequest request);

    RegistrationResponse.Builder toMessage(AggregateState state);
}
