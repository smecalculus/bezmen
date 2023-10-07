package smecalculus.bezmen.interior.storage;

import org.mapstruct.Mapper;
import smecalculus.bezmen.interior.core.Sepulka;

@Mapper
public interface SepulkaRecMapper {
    SepulkaRec toRec(Sepulka sepulka);

    Sepulka toDomain(SepulkaRec sepulkaRec);
}
