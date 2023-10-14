package smecalculus.bezmen.core;

import org.mapstruct.Mapper;

@Mapper
public interface SepulkaSliceMapper {
    Sepulka.Builder toDomain(SepulkaNewRequest request);

    SepulkaNewResponse toSlice(Sepulka sepulka);
}
