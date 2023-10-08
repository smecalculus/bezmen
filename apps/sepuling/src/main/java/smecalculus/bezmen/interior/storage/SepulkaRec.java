package smecalculus.bezmen.interior.storage;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("sepulkas")
public class SepulkaRec {
    @Id
    String id;

    @Version
    Integer version;

    String name;
}