package smecalculus.bezmen.messaging;

import java.util.UUID;
import org.mapstruct.Mapper;
import smecalculus.bezmen.core.SepulkaMessageDm;

@Mapper
public interface SepulkaMessageMapper {
    SepulkaMessageDm.RegistrationRequest toDomain(SepulkaMessageEm.RegistrationRequest request);

    SepulkaMessageEm.RegistrationResponse toEdge(SepulkaMessageDm.RegistrationResponse response);

    SepulkaMessageDm.ViewRequest toDomain(SepulkaMessageEm.ViewRequest request);

    SepulkaMessageEm.ViewResponse toEdge(SepulkaMessageDm.ViewResponse response);

    UUID toDomain(String uuid);
}
