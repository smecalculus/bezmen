package smecalculus.bezmen.messaging;

import org.mapstruct.Mapper;
import smecalculus.bezmen.core.SepulkaMessageDm;

@Mapper
public interface SepulkaMessageMapper {
    SepulkaMessageDm.RegistrationRequest toDomain(SepulkaMessageEm.RegistrationRequest request);

    SepulkaMessageEm.RegistrationResponse toEdge(SepulkaMessageDm.RegistrationResponse response);
}
