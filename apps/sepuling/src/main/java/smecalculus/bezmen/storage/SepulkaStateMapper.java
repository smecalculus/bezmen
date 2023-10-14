package smecalculus.bezmen.storage;

import org.mapstruct.Mapper;
import smecalculus.bezmen.core.Sepulka;

@Mapper
public interface SepulkaStateMapper {
    SepulkaEdge toEdge(Sepulka sepulka);

    Sepulka toDomain(SepulkaEdge sepulkaEdge);
}
