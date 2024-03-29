package smecalculus.bezmen.storage

import smecalculus.bezmen.core.SepulkaStateDm
import smecalculus.bezmen.storage.springdata.SepulkaRepository
import java.util.UUID

class SepulkaDaoSpringData(
    private val mapper: SepulkaStateMapper,
    private val repository: SepulkaRepository,
) : SepulkaDao {
    override fun addNew(state: SepulkaStateDm.AggregateRoot): SepulkaStateDm.AggregateRoot {
        val stateEdge = mapper.toEdge(state)
        repository.insert(stateEdge)
        return state
    }

    override fun getBy(externalId: String): SepulkaStateDm.Existence? {
        return repository.findByExternalId(externalId)?.let { mapper.toDomain(it) }
    }

    override fun getBy(internalId: UUID): SepulkaStateDm.Viewing? {
        return repository.findByInternalId(internalId)?.let { mapper.toDomain(it) }
    }

    override fun touchBy(
        internalId: UUID,
        state: SepulkaStateDm.Touch,
    ) {
        val stateEdge = mapper.toEdge(state)
        val matchedCount = repository.updateBy(internalId, stateEdge)
        if (matchedCount == 0) {
            throw ContentionException()
        }
    }
}
