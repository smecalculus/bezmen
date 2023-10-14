package smecalculus.bezmen.messaging;

import org.mapstruct.Mapper;
import smecalculus.bezmen.core.SepulkaNewRequest;
import smecalculus.bezmen.core.SepulkaNewResponse;

@Mapper
public interface SepulkaMsgMapper {
    SepulkaNewRequest toDomain(SepulkaNewRequestMsg requestMsg);

    SepulkaNewResponseMsg toMsg(SepulkaNewResponse response);

    SepulkaNewResponse toDomain(SepulkaNewResponseMsg responseMsg);
}
