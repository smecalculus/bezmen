package org.smecalculus.bezmen.data.spec;

import org.mapstruct.Mapper;
import org.smecalculus.bezmen.service.spec.Sepulka;

@Mapper
public interface SepulkaRecMapper {
    SepulkaRec toRec(Sepulka sepulka);

    Sepulka toDomain(SepulkaRec sepulkaRec);
}
