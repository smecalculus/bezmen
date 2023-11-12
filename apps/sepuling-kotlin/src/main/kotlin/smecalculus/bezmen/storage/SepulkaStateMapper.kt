package smecalculus.bezmen.storage

import org.mapstruct.Mapper
import smecalculus.bezmen.core.StateDm
import smecalculus.bezmen.mapping.EdgeMapper

@Mapper
interface SepulkaStateMapper : EdgeMapper {
    fun toEdge(state: StateDm.AggregateRoot): StateEm.AggregateRoot

    fun toDomain(state: StateEm.AggregateRoot): StateDm.AggregateRoot

    fun toEdge(state: StateDm.Touch): StateEm.Touch

    fun toDomain(state: StateEm.Existence): StateDm.Existence

    fun toEdge(state: StateDm.Preview): StateEm.Preview

    fun toDomain(state: StateEm.Preview): StateDm.Preview
}
