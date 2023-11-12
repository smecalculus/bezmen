package smecalculus.bezmen.storage.springdata

import org.springframework.data.jdbc.repository.query.Modifying
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import smecalculus.bezmen.storage.StateEm
import java.util.UUID

interface SepulkaRepository : CrudRepository<StateEm.AggregateRoot, String> {
    fun findByExternalId(externalId: String): StateEm.Existence?

    fun findByInternalId(internalId: UUID): StateEm.Preview?

    @Modifying
    @Query(
        """
        UPDATE sepulkas
        SET revision = revision + 1,
            updated_at = :#{#state.updatedAt}
        WHERE internal_id = :id
        AND revision = :#{#state.revision}
        """,
    )
    fun updateBy(
        @Param("state") state: StateEm.Touch,
        @Param("id") internalId: UUID,
    ): Int
}
