package smecalculus.bezmen.exterior.messaging;

import org.mapstruct.Mapper;

@Mapper
public interface SepulkaMsgMapper {
    SepulkaRegisterSliceMsg toMsg(SepulkaRegisterSlice slice);

    SepulkaRegisterSlice toDomain(SepulkaRegisterSliceMsg sliceMsg);

    SepulkaRegisteredSliceMsg toMsg(SepulkaRegisteredSlice slice);

    SepulkaRegisteredSlice toDomain(SepulkaRegisteredSliceMsg sliceMsg);
}
