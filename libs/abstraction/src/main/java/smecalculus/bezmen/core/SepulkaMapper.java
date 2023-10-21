package smecalculus.bezmen.core;

import org.mapstruct.Mapper;
import smecalculus.bezmen.core.ClientSide.RegistrationRequest;
import smecalculus.bezmen.core.ClientSide.RegistrationResponse;
import smecalculus.bezmen.core.ServerSide.AggregateState;

@Mapper
public interface SepulkaMapper {
    AggregateState.Builder toServer(RegistrationRequest request);

    RegistrationResponse.Builder toClient(AggregateState state);
}
