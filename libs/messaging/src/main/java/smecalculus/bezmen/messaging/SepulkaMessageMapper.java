package smecalculus.bezmen.messaging;

import org.mapstruct.Mapper;
import smecalculus.bezmen.core.ClientSide;

@Mapper
public interface SepulkaMessageMapper {
    ClientSide.RegistrationRequest toDomain(EdgeSide.RegistrationRequest request);

    EdgeSide.RegistrationResponse toEdge(ClientSide.RegistrationResponse response);
}
