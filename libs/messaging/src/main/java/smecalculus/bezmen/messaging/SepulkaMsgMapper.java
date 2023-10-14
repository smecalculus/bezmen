package smecalculus.bezmen.messaging;

import org.mapstruct.Mapper;
import smecalculus.bezmen.core.SepulkaNewRequest;
import smecalculus.bezmen.core.SepulkaNewResponse;

@Mapper
public interface SepulkaMsgMapper {
    SepulkaNewRequest toDomain(SepulkaNewRequestEdge requestEdge);

    SepulkaNewResponseEdge toEdge(SepulkaNewResponse response);

    SepulkaNewResponse toDomain(SepulkaNewResponseEdge responseEdge);
}
