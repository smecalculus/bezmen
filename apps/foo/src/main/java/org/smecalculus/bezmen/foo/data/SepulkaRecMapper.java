package org.smecalculus.bezmen.foo.data;

import org.mapstruct.Mapper;
import org.smecalculus.bezmen.foo.service.Sepulka;

@Mapper(componentModel = "spring")
public interface SepulkaRecMapper {
    SepulkaRec toRec(Sepulka sepulka);
    Sepulka toDomain(SepulkaRec sepulkaRec);
}
