package org.smecalculus.bezmen.messaging;

import org.mapstruct.Mapper;
import org.smecalculus.bezmen.client.SepulkaRegReq;
import org.smecalculus.bezmen.client.SepulkaRegRes;

@Mapper(componentModel = "spring")
public interface SepulkaMsgMapper {
    public SepulkaRegReqMsg toMsg(SepulkaRegReq sepulkaRegReq);
    public SepulkaRegReq toDomain(SepulkaRegReqMsg sepulkaRegReqMsg);
    public SepulkaRegResMsg toMsg(SepulkaRegRes sepulkaRegRes);
    public SepulkaRegRes toDomain(SepulkaRegResMsg sepulkaRegResMsg);
}
