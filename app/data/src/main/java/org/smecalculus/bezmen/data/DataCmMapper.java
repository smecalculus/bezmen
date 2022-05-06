package org.smecalculus.bezmen.data;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DataCmMapper {

    @Mapping(target = "h2Props", source = "h2")
    @Mapping(target = "postgresProps", source = "postgres")
    DataProps from(DataPropsCm dataPropsCm);

    default DataMode from(String mode) {
        return DataMode.valueOf(mode.toUpperCase());
    }
}
