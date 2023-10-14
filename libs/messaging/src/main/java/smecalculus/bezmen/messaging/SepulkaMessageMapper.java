package smecalculus.bezmen.messaging;

import org.mapstruct.Mapper;
import smecalculus.bezmen.core.SepulkaNewRequest;
import smecalculus.bezmen.core.SepulkaNewResponse;

@Mapper
public interface SepulkaMessageMapper {
    SepulkaNewRequest toDomain(SepulkaNewRequestEdge requestEdge);

    SepulkaNewResponseEdge toEdge(SepulkaNewResponse response);
}
