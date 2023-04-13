package org.smecalculus.bezmen.messaging;

import org.mapstruct.Mapper;

@Mapper
public interface SepulkaMsgMapper {
    SepulkaRegReqMsg toMsg(SepulkaRegReq sepulkaRegReq);
    SepulkaRegReq toDomain(SepulkaRegReqMsg sepulkaRegReqMsg);
    SepulkaRegResMsg toMsg(SepulkaRegRes sepulkaRegRes);
    SepulkaRegRes toDomain(SepulkaRegResMsg sepulkaRegResMsg);
}
