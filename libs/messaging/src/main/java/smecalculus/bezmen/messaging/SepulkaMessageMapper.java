package smecalculus.bezmen.messaging;

import org.mapstruct.Mapper;
import smecalculus.bezmen.core.MessageDomain;
import smecalculus.bezmen.mapping.EdgeMapper;

@Mapper
public interface SepulkaMessageMapper extends EdgeMapper {
    MessageDomain.RegistrationRequest toDomain(MessageEdge.RegistrationRequest request);

    MessageEdge.RegistrationResponse toEdge(MessageDomain.RegistrationResponse response);
}
