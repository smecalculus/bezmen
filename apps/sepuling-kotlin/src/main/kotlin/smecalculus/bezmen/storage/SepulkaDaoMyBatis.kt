package smecalculus.bezmen.storage

import smecalculus.bezmen.core.StateDm
import smecalculus.bezmen.storage.mybatis.SepulkaSqlMapper
import java.util.UUID

class SepulkaDaoMyBatis(
    private val stateMapper: SepulkaStateMapper,
    private val sqlMapper: SepulkaSqlMapper
) : SepulkaDao {

    override fun add(state: StateDm.AggregateState): StateDm.AggregateState {
        val stateEdge = stateMapper.toEdge(state)
        sqlMapper.insert(stateEdge)
        return state
    }

    override fun getBy(externalId: String): StateDm.ExistenceState? {
        return sqlMapper.findByExternalId(externalId)?.let { stateMapper.toDomain(it) }
    }

    override fun getBy(internalId: UUID): StateDm.PreviewState? {
        return sqlMapper.findByInternalId(internalId.toString())?.let { stateMapper.toDomain(it) }
    }

    override fun updateBy(state: StateDm.TouchState, internalId: UUID) {
        val stateEdge = stateMapper.toEdge(state)
        val matchedCount = sqlMapper.updateBy(stateEdge, internalId.toString())
        if (matchedCount == 0) {
            throw ContentionException()
        }
    }
}
