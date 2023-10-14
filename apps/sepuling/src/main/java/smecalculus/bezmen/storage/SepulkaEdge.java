package smecalculus.bezmen.storage;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Table;

/**
 * Model: edge entity
 */
@Data
@Table("sepulkas")
public class SepulkaEdge {
    @Id
    String id;

    @Version
    Integer version;

    String name;
}
