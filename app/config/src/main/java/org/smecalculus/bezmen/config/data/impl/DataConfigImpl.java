package org.smecalculus.bezmen.config.data.impl;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigBeanFactory;
import lombok.NonNull;
import org.smecalculus.bezmen.config.data.contract.BezmenValidator;
import org.smecalculus.bezmen.config.data.contract.DataConfig;
import org.smecalculus.bezmen.config.data.contract.DataProps;
import org.smecalculus.bezmen.config.data.spring.DataPropsCm;

public record DataConfigImpl(
        @NonNull Config config,
        @NonNull BezmenValidator validator,
        @NonNull CmMapper cmMapper
) implements DataConfig {

    @Override
    public DataProps getDataProps() {
        DataPropsCm dataPropsCm = ConfigBeanFactory.create(config.getConfig("bezmen.data"), DataPropsCm.class);
        validator.validate(dataPropsCm);
        return cmMapper.from(dataPropsCm);
    }
}
