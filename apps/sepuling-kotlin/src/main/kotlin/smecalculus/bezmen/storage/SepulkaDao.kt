package smecalculus.bezmen.storage

import smecalculus.bezmen.core.StateDm
import java.util.UUID

/**
 * Port: server side
 */
interface SepulkaDao {
    fun add(state: StateDm.AggregateState): StateDm.AggregateState
    fun getBy(externalId: String): StateDm.ExistenceState?
    fun getBy(internalId: UUID): StateDm.PreviewState?
    fun updateBy(state: StateDm.TouchState, internalId: UUID)
}
