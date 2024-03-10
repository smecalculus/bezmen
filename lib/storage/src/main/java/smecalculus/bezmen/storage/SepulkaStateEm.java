package smecalculus.bezmen.storage;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

public abstract class SepulkaStateEm {
    @Data
    public static class Existence {
        UUID internalId;
    }

    @Data
    public static class Viewing {
        String externalId;
    }

    @Data
    public static class Touch {
        Integer revision;
        LocalDateTime updatedAt;
    }

    @Data
    @Table("sepulkas")
    public static class AggregateRoot {
        @Id
        UUID internalId;

        @Column
        String externalId;

        @Column
        Integer revision;

        @Column
        LocalDateTime createdAt;

        @Column
        LocalDateTime updatedAt;
    }
}
