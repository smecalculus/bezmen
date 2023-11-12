package smecalculus.bezmen.storage

import smecalculus.bezmen.core.StateDm
import java.util.UUID

/**
 * Port: server side
 */
interface SepulkaDao {
    fun add(state: StateDm.AggregateRoot): StateDm.AggregateRoot

    fun getBy(externalId: String): StateDm.Existence?

    fun getBy(internalId: UUID): StateDm.Preview?

    fun updateBy(
        state: StateDm.Touch,
        internalId: UUID,
    )
}
