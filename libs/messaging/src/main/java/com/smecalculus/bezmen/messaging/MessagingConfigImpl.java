package com.smecalculus.bezmen.messaging;

import com.smecalculus.bezmen.messaging.model.MessagingProps;
import com.smecalculus.bezmen.messaging.model.MessagingPropsCm;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigBeanFactory;
import lombok.NonNull;
import org.smecalculus.bezmen.core.validation.BezmenValidator;

record MessagingConfigImpl(
        @NonNull Config config,
        @NonNull BezmenValidator validator,
        @NonNull MessagingMapper mapper
) implements MessagingConfig {

    @Override
    public MessagingProps getMessagingProps() {
        MessagingPropsCm propsCm = ConfigBeanFactory.create(config.getConfig("bezmen.messaging"), MessagingPropsCm.class);
        validator.validate(propsCm);
        return mapper.from(propsCm);
    }
}
