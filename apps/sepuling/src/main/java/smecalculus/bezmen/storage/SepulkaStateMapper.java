package smecalculus.bezmen.storage;

import org.mapstruct.Mapper;
import smecalculus.bezmen.core.StateDomain;
import smecalculus.bezmen.mapping.EdgeMapper;

@Mapper
public interface SepulkaStateMapper extends EdgeMapper {
    StateEdge.AggregateState toEdge(StateDomain.AggregateState state);

    StateDomain.AggregateState toDomain(StateEdge.AggregateState state);

    StateEdge.TouchState toEdge(StateDomain.TouchState state);

    StateDomain.ExistenceState toDomain(StateEdge.ExistenceState state);

    StateEdge.PreviewState toEdge(StateDomain.PreviewState state);

    StateDomain.PreviewState toDomain(StateEdge.PreviewState state);
}
