package org.smecalculus.bezmen.configuration;

import lombok.NonNull;
import org.smecalculus.bezmen.validation.BezmenValidator;

record DataConfigImpl(
        @NonNull ConfigKeeper configKeeper,
        @NonNull BezmenValidator validator,
        @NonNull DataMapper mapper
) implements DataConfig {

    @Override
    public DataProps getDataProps() {
        DataPropsCfg dataPropsCfg = configKeeper.read("bezmen.data", DataPropsCfg.class);
        validator.validate(dataPropsCfg);
        return mapper.from(dataPropsCfg);
    }
}
