package smecalculus.bezmen.storage.mybatis;

import java.util.Optional;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import smecalculus.bezmen.storage.EdgeSide.AggregateState;
import smecalculus.bezmen.storage.EdgeSide.CreationState;
import smecalculus.bezmen.storage.EdgeSide.PreviewState;
import smecalculus.bezmen.storage.EdgeSide.TouchState;

public interface SepulkaSqlMapper {

    @Insert(
            """
            INSERT INTO sepulkas (
                internal_id,
                external_id,
                version,
                created_at,
                updated_at
            )
            VALUES (
                #{internalId},
                #{externalId},
                #{version},
                #{createdAt},
                #{updatedAt}
            )
            """)
    void insert(AggregateState state);

    @Select(
            """
            SELECT
                internal_id as internalId
            FROM sepulkas
            WHERE external_id = #{externalId}
            """)
    Optional<CreationState> findByExternalId(String externalId);

    @Select(
            """
            SELECT
                external_id as externalId
            FROM sepulkas
            WHERE internal_id = #{internalId}
            """)
    Optional<PreviewState> findByInternalId(String internalId);

    @Update(
            """
           UPDATE sepulkas
           SET version = #{state.version} + 1,
            updated_at = #{state.updatedAt}
           WHERE internal_id = #{id}
           AND version = #{state.version}
           """)
    void updateBy(@Param("state") TouchState state, @Param("id") String internalId);
}
