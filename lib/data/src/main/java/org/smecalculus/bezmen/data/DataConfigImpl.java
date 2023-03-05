package org.smecalculus.bezmen.data;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigBeanFactory;
import lombok.NonNull;
import org.smecalculus.bezmen.core.validation.BezmenValidator;
import org.smecalculus.bezmen.data.model.DataProps;
import org.smecalculus.bezmen.data.model.DataPropsCm;

record DataConfigImpl(
        @NonNull Config config,
        @NonNull BezmenValidator validator,
        @NonNull DataMapper mapper
) implements DataConfig {

    @Override
    public DataProps getDataProps() {
        DataPropsCm dataPropsCm = ConfigBeanFactory.create(config.getConfig("bezmen.data"), DataPropsCm.class);
        validator.validate(dataPropsCm);
        return mapper.from(dataPropsCm);
    }
}
