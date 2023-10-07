package smecalculus.bezmen.interior.core;

import org.mapstruct.Mapper;
import smecalculus.bezmen.exterior.messaging.SepulkaRegisteredSlice;

@Mapper
public interface SepulkaSliceMapper {
    SepulkaRegisteredSlice toSlice(Sepulka sepulka);
}
