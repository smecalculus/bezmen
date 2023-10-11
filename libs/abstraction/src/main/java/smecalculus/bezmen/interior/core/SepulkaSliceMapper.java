package smecalculus.bezmen.interior.core;

import org.mapstruct.Mapper;
import smecalculus.bezmen.exterior.messaging.SepulkaRegisterSlice;
import smecalculus.bezmen.exterior.messaging.SepulkaRegisteredSlice;

@Mapper
public interface SepulkaSliceMapper {
    Sepulka.Builder toDomain(SepulkaRegisterSlice slice);

    SepulkaRegisteredSlice toSlice(Sepulka sepulka);
}
