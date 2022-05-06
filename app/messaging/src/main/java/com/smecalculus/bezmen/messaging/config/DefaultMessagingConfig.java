package com.smecalculus.bezmen.messaging.config;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigBeanFactory;
import lombok.NonNull;
import org.smecalculus.bezmen.core.validation.BezmenValidator;

public record DefaultMessagingConfig(
        @NonNull Config config,
        @NonNull BezmenValidator validator,
        @NonNull MessagingCmMapper mapper
) implements MessagingConfig {

    @Override
    public MessagingProps getMessagingProps() {
        MessagingPropsCm propsCm = ConfigBeanFactory.create(config.getConfig("bezmen.messaging"), MessagingPropsCm.class);
        validator.validate(propsCm);
        return mapper.from(propsCm);
    }
}
