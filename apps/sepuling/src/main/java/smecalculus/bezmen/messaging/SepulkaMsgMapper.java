package smecalculus.bezmen.messaging;

import org.mapstruct.Mapper;
import smecalculus.bezmen.messaging.client.SepulkaRegisterSlice;
import smecalculus.bezmen.messaging.client.SepulkaRegisteredSlice;

@Mapper
public interface SepulkaMsgMapper {
    SepulkaRegisterSliceMsg toMsg(SepulkaRegisterSlice slice);

    SepulkaRegisterSlice toDomain(SepulkaRegisterSliceMsg sliceMsg);

    SepulkaRegisteredSliceMsg toMsg(SepulkaRegisteredSlice slice);

    SepulkaRegisteredSlice toDomain(SepulkaRegisteredSliceMsg sliceMsg);
}
