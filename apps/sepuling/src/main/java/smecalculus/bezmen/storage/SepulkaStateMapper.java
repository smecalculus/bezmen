package smecalculus.bezmen.storage;

import org.mapstruct.Mapper;
import smecalculus.bezmen.core.ServerSide;

@Mapper
public interface SepulkaStateMapper {
    EdgeSide.AggregateState toEdge(ServerSide.StorageState state);

    ServerSide.StorageState toDomain(EdgeSide.AggregateState state);

    EdgeSide.TouchState toEdge(ServerSide.TouchState state);

    ServerSide.CreationState toDomain(EdgeSide.CreationState state);

    ServerSide.PreviewState toDomain(EdgeSide.PreviewState state);
}
