package org.smecalculus.bezmen.config.data.impl;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.smecalculus.bezmen.config.data.contract.DataMode;
import org.smecalculus.bezmen.config.data.contract.DataProps;
import org.smecalculus.bezmen.config.data.spring.DataPropsCm;

@Mapper(componentModel = "spring")
public interface CmMapper {

    @Mapping(target = "h2Props", source = "h2")
    @Mapping(target = "postgresProps", source = "postgres")
    DataProps from(DataPropsCm dataPropsCm);

    default DataMode from(String mode) {
        return DataMode.valueOf(mode.toUpperCase());
    }
}
