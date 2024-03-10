package smecalculus.bezmen.storage.springdata

import org.springframework.data.jdbc.repository.query.Modifying
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import smecalculus.bezmen.storage.SepulkaStateEm
import java.util.UUID

interface SepulkaRepository : CrudRepository<SepulkaStateEm.AggregateRoot, UUID> {
    @Modifying
    @Query(
        """
        INSERT INTO sepulkas (
            internal_id,
            external_id,
            revision,
            created_at,
            updated_at
        )
        VALUES (
            :#{#state.internalId},
            :#{#state.externalId},
            :#{#state.revision},
            :#{#state.createdAt},
            :#{#state.updatedAt}
        )
        """,
    )
    fun insert(
        @Param("state") state: SepulkaStateEm.AggregateRoot,
    )

    fun findByExternalId(externalId: String): SepulkaStateEm.Existence?

    fun findByInternalId(internalId: UUID): SepulkaStateEm.Viewing?

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
        @Param("id") internalId: UUID,
        @Param("state") state: SepulkaStateEm.Touch,
    ): Int
}
