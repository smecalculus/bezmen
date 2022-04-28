package org.smecalculus.bezmen.config.data.impl;

import org.mapstruct.Mapper;
import org.smecalculus.bezmen.config.data.contract.DataProps;
import org.smecalculus.bezmen.config.data.spring.DataPropsCm;

@Mapper(componentModel = "spring")
public interface CmMapper {

    DataProps map(DataPropsCm dataPropsCm);
}
