package org.smecalculus.bezmen.messaging;

import org.mapstruct.Mapper;
import org.smecalculus.bezmen.client.SepulkaRegReq;
import org.smecalculus.bezmen.client.SepulkaRegRes;

@Mapper(componentModel = "spring")
public interface SepulkaMsgMapper {
    SepulkaRegReqMsg toMsg(SepulkaRegReq sepulkaRegReq);
    SepulkaRegReq toDomain(SepulkaRegReqMsg sepulkaRegReqMsg);
    SepulkaRegResMsg toMsg(SepulkaRegRes sepulkaRegRes);
    SepulkaRegRes toDomain(SepulkaRegResMsg sepulkaRegResMsg);
}
