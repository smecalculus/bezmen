package org.smecalculus.bezmen.configuration;

import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smecalculus.bezmen.modeling.DataConfig;
import org.smecalculus.bezmen.modeling.DataProps;
import org.smecalculus.bezmen.validation.BezmenValidator;

public record DataConfigImpl(
        @NonNull ConfigKeeper configKeeper,
        @NonNull BezmenValidator validator,
        @NonNull DataCfgMapper mapper
) implements DataConfig {

    private static final Logger LOG = LoggerFactory.getLogger(DataConfigImpl.class);

    @Override
    public DataProps getDataProps() {
        DataPropsCfg dataPropsCfg = configKeeper.read("bezmen.data", DataPropsCfg.class);
        validator.validate(dataPropsCfg);
        LOG.info("Read props: {}", dataPropsCfg);
        return mapper.toDomain(dataPropsCfg);
    }
}
