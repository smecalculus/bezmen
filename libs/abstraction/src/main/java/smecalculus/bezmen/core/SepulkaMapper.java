package smecalculus.bezmen.core;

import org.mapstruct.Mapper;
import smecalculus.bezmen.core.MessageDm.RegistrationRequest;
import smecalculus.bezmen.core.MessageDm.RegistrationResponse;
import smecalculus.bezmen.core.StateDm.AggregateRoot;

@Mapper
public interface SepulkaMapper {
    AggregateRoot.Builder toState(RegistrationRequest request);

    RegistrationResponse.Builder toMessage(AggregateRoot state);
}
