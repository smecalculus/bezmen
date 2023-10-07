package smecalculus.bezmen.core;

import org.mapstruct.Mapper;
import smecalculus.bezmen.messaging.client.SepulkaRegisteredSlice;

@Mapper
public interface SepulkaSliceMapper {
    SepulkaRegisteredSlice toSlice(Sepulka sepulka);
}
