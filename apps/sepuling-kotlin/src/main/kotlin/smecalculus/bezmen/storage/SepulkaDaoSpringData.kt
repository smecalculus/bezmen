package smecalculus.bezmen.storage

import smecalculus.bezmen.core.StateDm
import smecalculus.bezmen.storage.springdata.SepulkaRepository
import java.util.UUID

class SepulkaDaoSpringData(
    private val mapper: SepulkaStateMapper,
    private val repository: SepulkaRepository
) : SepulkaDao {

    override fun add(state: StateDm.AggregateState): StateDm.AggregateState {
        val stateEdge = repository.save(mapper.toEdge(state))
        return mapper.toDomain(stateEdge)
    }

    override fun getBy(externalId: String): StateDm.ExistenceState? {
        return repository
            .findByExternalId(externalId, StateEm.ExistenceState::class)?.let { mapper.toDomain(it) }
    }

    override fun getBy(internalId: UUID): StateDm.PreviewState? {
        return repository
            .findByInternalId(internalId.toString(), StateEm.PreviewState::class)?.let { mapper.toDomain(it) }
    }

    override fun updateBy(state: StateDm.TouchState, internalId: UUID) {
        val stateEdge = mapper.toEdge(state)
        val matchedCount = repository.updateBy(stateEdge, internalId.toString())
        if (matchedCount == 0) {
            throw ContentionException()
        }
    }
}
