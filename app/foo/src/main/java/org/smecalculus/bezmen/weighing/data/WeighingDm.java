package org.smecalculus.bezmen.weighing.data;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("weighings")
public class WeighingDm {
    @Id
    String id;
    @Version
    Integer version;
}
