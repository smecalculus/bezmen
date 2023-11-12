package smecalculus.bezmen.storage;

import org.mapstruct.Mapper;
import smecalculus.bezmen.core.StateDm;
import smecalculus.bezmen.mapping.EdgeMapper;

@Mapper
public interface SepulkaStateMapper extends EdgeMapper {
    StateEm.AggregateRoot toEdge(StateDm.AggregateRoot state);

    StateDm.AggregateRoot toDomain(StateEm.AggregateRoot state);

    StateEm.Touch toEdge(StateDm.Touch state);

    StateDm.Existence toDomain(StateEm.Existence state);

    StateEm.Preview toEdge(StateDm.Preview state);

    StateDm.Preview toDomain(StateEm.Preview state);
}
