package org.smecalculus.bezmen.configuration;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigBeanFactory;
import lombok.NonNull;
import org.smecalculus.bezmen.core.validation.BezmenValidator;

record DataConfigLightbendConfig(
        @NonNull Config config,
        @NonNull BezmenValidator validator,
        @NonNull DataMapper mapper
) implements DataConfig {

    @Override
    public DataProps getDataProps() {
        DataPropsDTO dataPropsDTO = ConfigBeanFactory.create(config.getConfig("bezmen.data"), DataPropsDTO.class);
        validator.validate(dataPropsDTO);
        return mapper.from(dataPropsDTO);
    }
}
