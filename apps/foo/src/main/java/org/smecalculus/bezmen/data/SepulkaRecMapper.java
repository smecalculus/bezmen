package org.smecalculus.bezmen.data;

import org.mapstruct.Mapper;
import org.smecalculus.bezmen.domain.Sepulka;

@Mapper
public interface SepulkaRecMapper {
    SepulkaRec toRec(Sepulka sepulka);
    Sepulka toDomain(SepulkaRec sepulkaRec);
}
