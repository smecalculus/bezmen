package org.smecalculus.bezmen.configuration;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface DataMapper {

    @Mapping(target = "h2Props", source = "h2")
    @Mapping(target = "postgresProps", source = "postgres")
    DataProps from(DataPropsCfg dataPropsCfg);

    default DataMode from(String mode) {
        return DataMode.valueOf(mode.toUpperCase());
    }
}
