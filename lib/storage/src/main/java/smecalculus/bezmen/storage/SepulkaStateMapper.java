package smecalculus.bezmen.storage;

import org.mapstruct.Mapper;
import smecalculus.bezmen.core.SepulkaStateDm;

@Mapper
public interface SepulkaStateMapper {
    SepulkaStateEm.AggregateRoot toEdge(SepulkaStateDm.AggregateRoot state);

    SepulkaStateDm.AggregateRoot toDomain(SepulkaStateEm.AggregateRoot state);

    SepulkaStateEm.Touch toEdge(SepulkaStateDm.Touch state);

    SepulkaStateDm.Existence toDomain(SepulkaStateEm.Existence state);

    SepulkaStateEm.Viewing toEdge(SepulkaStateDm.Viewing state);

    SepulkaStateDm.Viewing toDomain(SepulkaStateEm.Viewing state);
}
