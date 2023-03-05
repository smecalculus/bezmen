package org.smecalculus.bezmen.data;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.smecalculus.bezmen.data.model.DataMode;
import org.smecalculus.bezmen.data.model.DataProps;
import org.smecalculus.bezmen.data.model.DataPropsCm;

@Mapper(componentModel = "spring")
interface DataMapper {

    @Mapping(target = "h2Props", source = "h2")
    @Mapping(target = "postgresProps", source = "postgres")
    DataProps from(DataPropsCm dataPropsCm);

    default DataMode from(String mode) {
        return DataMode.valueOf(mode.toUpperCase());
    }
}
