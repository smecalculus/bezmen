package smecalculus.bezmen.storage;

import org.mapstruct.Mapper;
import smecalculus.bezmen.core.ServerSide;
import smecalculus.bezmen.mapping.EdgeMapper;

@Mapper
public interface SepulkaStateMapper extends EdgeMapper {
    EdgeSide.AggregateState toEdge(ServerSide.AggregateState state);

    ServerSide.AggregateState toDomain(EdgeSide.AggregateState state);

    EdgeSide.TouchState toEdge(ServerSide.TouchState state);

    ServerSide.ExistenceState toDomain(EdgeSide.ExistenceState state);

    EdgeSide.PreviewState toEdge(ServerSide.PreviewState state);

    ServerSide.PreviewState toDomain(EdgeSide.PreviewState state);
}
