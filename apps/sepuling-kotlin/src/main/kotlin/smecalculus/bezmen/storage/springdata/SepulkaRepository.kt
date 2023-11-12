package smecalculus.bezmen.storage.springdata

import org.springframework.data.jdbc.repository.query.Modifying
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.lang.Nullable
import smecalculus.bezmen.storage.StateEm
import kotlin.reflect.KClass

interface SepulkaRepository : CrudRepository<StateEm.AggregateState, String> {
    fun <T : Any> findByExternalId(@Nullable externalId: String, type: KClass<T>): T?
    fun <T : Any> findByInternalId(@Nullable internalId: String, type: KClass<T>): T?

    @Modifying
    @Query(
        """
            UPDATE sepulkas
            SET revision = revision + 1,
                updated_at = :#{#state.updatedAt}
            WHERE internal_id = :id
            AND revision = :#{#state.revision}
        """
    )
    fun updateBy(@Param("state") state: StateEm.TouchState, @Param("id") internalId: String): Int
}
