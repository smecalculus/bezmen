package smecalculus.bezmen.storage;

import java.time.LocalDateTime;
import lombok.Data;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

public abstract class EdgeSide {

    @Data
    public static class CreationState {
        String internalId;
    }

    @Data
    public static class PreviewState {
        String externalId;
        LocalDateTime createdAt;
    }

    @Data
    public static class TouchState {
        Integer revision;
        LocalDateTime updatedAt;
    }

    @Data
    @Table("sepulkas")
    public static class AggregateState implements Persistable<String> {
        @Column
        String internalId;

        @Column
        String externalId;

        @Column
        Integer revision;

        @Column
        LocalDateTime createdAt;

        @Column
        LocalDateTime updatedAt;

        @Override
        public String getId() {
            return internalId;
        }

        @Override
        public boolean isNew() {
            return true;
        }
    }
}
