package smecalculus.bezmen.messaging;

import org.mapstruct.Mapper;
import smecalculus.bezmen.messaging.client.SepulkaRegReq;
import smecalculus.bezmen.messaging.client.SepulkaRegRes;

@Mapper
public interface SepulkaMsgMapper {
    SepulkaRegReqMsg toMsg(SepulkaRegReq sepulkaRegReq);

    SepulkaRegReq toDomain(SepulkaRegReqMsg sepulkaRegReqMsg);

    SepulkaRegResMsg toMsg(SepulkaRegRes sepulkaRegRes);

    SepulkaRegRes toDomain(SepulkaRegResMsg sepulkaRegResMsg);
}
