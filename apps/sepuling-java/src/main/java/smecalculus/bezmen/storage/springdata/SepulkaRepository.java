package smecalculus.bezmen.storage.springdata;

import java.util.Optional;
import java.util.UUID;
import lombok.NonNull;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import smecalculus.bezmen.storage.StateEm;

public interface SepulkaRepository extends CrudRepository<StateEm.AggregateRoot, String> {

    Optional<StateEm.Existence> findByExternalId(@NonNull String externalId);

    Optional<StateEm.Preview> findByInternalId(@NonNull UUID internalId);

    @Modifying
    @Query(
            """
            UPDATE sepulkas
            SET revision = revision + 1,
                updated_at = :#{#state.updatedAt}
            WHERE internal_id = :id
            AND revision = :#{#state.revision}
            """)
    int updateBy(@Param("state") StateEm.Touch state, @Param("id") UUID internalId);
}
