package smecalculus.bezmen.core;

import org.mapstruct.Mapper;

@Mapper
public interface SepulkaSliceMapper {
    Sepulka.Builder toEntity(SepulkaNewRequest request);

    SepulkaNewResponse toSlice(Sepulka sepulka);
}
