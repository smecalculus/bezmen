package smecalculus.bezmen.storage.mybatis

import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.Update
import smecalculus.bezmen.storage.SepulkaStateEm
import java.util.UUID

interface SepulkaSqlMapper {
    @Insert(
        """
        INSERT INTO sepulkas (
            internal_id,
            external_id,
            revision,
            created_at,
            updated_at
        )
        VALUES (
            #{internalId},
            #{externalId},
            #{revision},
            #{createdAt},
            #{updatedAt}
        )
        """,
    )
    fun insert(state: SepulkaStateEm.AggregateRoot)

    @Select(
        """
        SELECT
            internal_id as internalId
        FROM sepulkas
        WHERE external_id = #{id}
        """,
    )
    fun findByExternalId(
        @Param("id") id: String,
    ): SepulkaStateEm.Existence?

    @Select(
        """
        SELECT
            external_id as externalId
        FROM sepulkas
        WHERE internal_id = #{id}
        """,
    )
    fun findByInternalId(
        @Param("id") id: UUID,
    ): SepulkaStateEm.Viewing?

    @Update(
        """
        UPDATE sepulkas
        SET revision = revision + 1,
            updated_at = #{state.updatedAt}
        WHERE internal_id = #{id}
        AND revision = #{state.revision}
        """,
    )
    fun updateBy(
        @Param("id") internalId: UUID,
        @Param("state") state: SepulkaStateEm.Touch,
    ): Int
}
