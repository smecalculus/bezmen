package smecalculus.bezmen.messaging;

import org.mapstruct.Mapper;
import smecalculus.bezmen.core.ClientSide;
import smecalculus.bezmen.mapping.EdgeMapper;

@Mapper
public interface SepulkaMessageMapper extends EdgeMapper {
    ClientSide.RegistrationRequest toDomain(EdgeSide.RegistrationRequest request);

    EdgeSide.RegistrationResponse toEdge(ClientSide.RegistrationResponse response);
}
