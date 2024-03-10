package smecalculus.bezmen.storage

import smecalculus.bezmen.core.SepulkaStateDm
import smecalculus.bezmen.storage.mybatis.SepulkaSqlMapper
import java.util.UUID

class SepulkaDaoMyBatis(
    private val stateMapper: SepulkaStateMapper,
    private val sqlMapper: SepulkaSqlMapper,
) : SepulkaDao {
    override fun addNew(state: SepulkaStateDm.AggregateRoot): SepulkaStateDm.AggregateRoot {
        val stateEdge = stateMapper.toEdge(state)
        sqlMapper.insert(stateEdge)
        return state
    }

    override fun getBy(externalId: String): SepulkaStateDm.Existence? {
        return sqlMapper.findByExternalId(externalId)?.let { stateMapper.toDomain(it) }
    }

    override fun getBy(internalId: UUID): SepulkaStateDm.Viewing? {
        return sqlMapper.findByInternalId(internalId)?.let { stateMapper.toDomain(it) }
    }

    override fun touchBy(
        internalId: UUID,
        state: SepulkaStateDm.Touch,
    ) {
        val stateEdge = stateMapper.toEdge(state)
        val matchedCount = sqlMapper.updateBy(internalId, stateEdge)
        if (matchedCount == 0) {
            throw ContentionException()
        }
    }
}
