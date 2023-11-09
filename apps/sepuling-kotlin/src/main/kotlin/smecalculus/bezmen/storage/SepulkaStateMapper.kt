package smecalculus.bezmen.storage

import org.mapstruct.Mapper
import smecalculus.bezmen.core.StateDm
import smecalculus.bezmen.mapping.EdgeMapper

@Mapper
interface SepulkaStateMapper : EdgeMapper {
    fun toEdge(state: StateDm.AggregateState): StateEm.AggregateState
    fun toDomain(state: StateEm.AggregateState): StateDm.AggregateState
    fun toEdge(state: StateDm.TouchState): StateEm.TouchState
    fun toDomain(state: StateEm.ExistenceState): StateDm.ExistenceState
    fun toEdge(state: StateDm.PreviewState): StateEm.PreviewState
    fun toDomain(state: StateEm.PreviewState): StateDm.PreviewState
}
