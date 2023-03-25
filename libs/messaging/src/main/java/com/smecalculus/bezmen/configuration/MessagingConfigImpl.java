package com.smecalculus.bezmen.configuration;

import lombok.NonNull;
import org.smecalculus.bezmen.configuration.ConfigKeeper;
import org.smecalculus.bezmen.validation.BezmenValidator;

public record MessagingConfigImpl(
        @NonNull ConfigKeeper keeper,
        @NonNull BezmenValidator validator,
        @NonNull MessagingCfgMapper mapper
) implements MessagingConfig {

    @Override
    public MessagingProps getMessagingProps() {
        MessagingPropsCfg propsCfg = keeper.read("bezmen.messaging", MessagingPropsCfg.class);
        validator.validate(propsCfg);
        return mapper.toDomain(propsCfg);
    }
}
