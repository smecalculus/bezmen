package smecalculus.bezmen.storage.springdata;

import java.util.Optional;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;
import smecalculus.bezmen.storage.EdgeSide.AggregateState;
import smecalculus.bezmen.storage.EdgeSide.TouchState;

public interface SepulkaRepository extends CrudRepository<AggregateState, String> {

    <T> Optional<T> findByExternalId(@Nullable String externalId, Class<T> type);

    <T> Optional<T> findByInternalId(@Nullable String internalId, Class<T> type);

    @Modifying
    @Query(
            """
           UPDATE #{#entityName}
           SET version = :#{#state.version} + 1,
            updated_at = :#{#state.updatedAt}
           WHERE internal_id = :id
           AND version = :#{#state.version}
           """)
    void updateBy(@Param("state") TouchState state, @Param("id") String internalId);
}
