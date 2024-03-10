package smecalculus.bezmen.storage.mybatis;

import java.util.Optional;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import smecalculus.bezmen.storage.SepulkaStateEm.AggregateRoot;
import smecalculus.bezmen.storage.SepulkaStateEm.Existence;
import smecalculus.bezmen.storage.SepulkaStateEm.Touch;
import smecalculus.bezmen.storage.SepulkaStateEm.Viewing;

public interface SepulkaSqlMapper {

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
            """)
    void insert(AggregateRoot state);

    @Select(
            """
            SELECT
                internal_id as internalId
            FROM sepulkas
            WHERE external_id = #{id, jdbcType=VARCHAR}
            """)
    Optional<Existence> findByExternalId(@Param("id") String id);

    @Select(
            """
            SELECT
                external_id as externalId
            FROM sepulkas
            WHERE internal_id = #{id, jdbcType=OTHER}::uuid
            """)
    Optional<Viewing> findByInternalId(@Param("id") String id);

    @Update(
            """
            UPDATE sepulkas
            SET revision = revision + 1,
                updated_at = #{state.updatedAt}
            WHERE internal_id = #{id, jdbcType=OTHER}::uuid
            AND revision = #{state.revision}
            """)
    int updateBy(@Param("id") String internalId, @Param("state") Touch state);
}
