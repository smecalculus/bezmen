package smecalculus.bezmen.storage;

import org.mapstruct.Mapper;
import smecalculus.bezmen.core.SepulkaStateDm;

@Mapper
public interface SepulkaStateMapper {
    SepulkaStateEm.AggregateRoot toEdge(SepulkaStateDm.AggregateRoot state);

    SepulkaStateDm.AggregateRoot toDomain(SepulkaStateEm.AggregateRoot state);

    SepulkaStateEm.Touch toEdge(SepulkaStateDm.Touch state);

    SepulkaStateDm.Existence toDomain(SepulkaStateEm.Existence state);

    SepulkaStateEm.Preview toEdge(SepulkaStateDm.Preview state);

    SepulkaStateDm.Preview toDomain(SepulkaStateEm.Preview state);
}
