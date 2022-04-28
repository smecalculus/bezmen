package org.smecalculus.bezmen.config.data;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CmMapper {
    PostgresProps map(PostgresPropsCm postgresPropsCm);
}
