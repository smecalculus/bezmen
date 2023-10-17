package smecalculus.bezmen.storage;

import java.util.Date;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
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
        Date createdAt;
    }

    @Data
    public static class TouchState {
        Integer version;
        Date updatedAt;
    }

    @Data
    @Table("sepulkas")
    public static class AggregateState {
        @Id
        String internalId;

        @Column
        String externalId;

        @Version
        Integer version;

        @Column
        Date createdAt;

        @Column
        Date updatedAt;
    }
}
