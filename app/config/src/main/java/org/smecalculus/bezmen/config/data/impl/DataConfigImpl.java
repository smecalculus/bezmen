package org.smecalculus.bezmen.config.data.impl;

import lombok.NonNull;
import org.smecalculus.bezmen.config.data.contract.DataConfig;
import org.smecalculus.bezmen.config.data.contract.DataProps;
import org.smecalculus.bezmen.config.data.spring.DataPropsCm;
import org.smecalculus.bezmen.config.data.spring.H2PropsCm;

public record DataConfigImpl(
        @NonNull CmMapper cmMapper
) implements DataConfig {

    @Override
    public DataProps getDataProps() {
        DataPropsCm dataPropsCm = new DataPropsCm();
        dataPropsCm.setMode("H2");

        H2PropsCm h2PropsCm = new H2PropsCm();
        h2PropsCm.setUrl("jdbc:h2:mem:db;DB_CLOSE_DELAY=-1");
        h2PropsCm.setUsername("sa");
        h2PropsCm.setPassword("sa");

        dataPropsCm.setH2Props(h2PropsCm);
        return cmMapper.map(dataPropsCm);
    }
}
