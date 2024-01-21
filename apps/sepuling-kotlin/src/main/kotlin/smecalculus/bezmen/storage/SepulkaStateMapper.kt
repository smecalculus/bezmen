package smecalculus.bezmen.storage

import io.mcarle.konvert.api.Konverter
import smecalculus.bezmen.core.SepulkaStateDm
import smecalculus.bezmen.mapping.EdgeMapper

@Konverter
interface SepulkaStateMapper : EdgeMapper {
    fun toEdge(state: SepulkaStateDm.AggregateRoot): SepulkaStateEm.AggregateRoot

    fun toDomain(state: SepulkaStateEm.AggregateRoot): SepulkaStateDm.AggregateRoot

    fun toEdge(state: SepulkaStateDm.Touch): SepulkaStateEm.Touch

    fun toDomain(state: SepulkaStateEm.Existence): SepulkaStateDm.Existence

    fun toDomain(state: SepulkaStateEm.Preview): SepulkaStateDm.Preview
}
