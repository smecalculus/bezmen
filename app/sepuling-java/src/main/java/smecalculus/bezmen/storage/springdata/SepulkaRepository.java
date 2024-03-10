package smecalculus.bezmen.storage.springdata;

import java.util.Optional;
import java.util.UUID;
import lombok.NonNull;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import smecalculus.bezmen.storage.SepulkaStateEm;

public interface SepulkaRepository extends CrudRepository<SepulkaStateEm.AggregateRoot, UUID> {

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
            """)
    void insert(@Param("state") SepulkaStateEm.AggregateRoot state);

    Optional<SepulkaStateEm.Existence> findByExternalId(@NonNull String id);

    Optional<SepulkaStateEm.Viewing> findByInternalId(@NonNull UUID id);

    @Modifying
    @Query(
            """
            UPDATE sepulkas
            SET revision = revision + 1,
                updated_at = :#{#state.updatedAt}
            WHERE internal_id = :id
            AND revision = :#{#state.revision}
            """)
    int updateBy(@Param("id") UUID internalId, @Param("state") SepulkaStateEm.Touch state);
}
