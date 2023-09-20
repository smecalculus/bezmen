package smecalculus.bezmen.configuration.impl;

import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import smecalculus.bezmen.configuration.spec.ConfigKeeper;
import smecalculus.bezmen.configuration.spec.MessagingCfgMapper;
import smecalculus.bezmen.configuration.spec.MessagingConfig;
import smecalculus.bezmen.configuration.spec.MessagingProps;
import smecalculus.bezmen.configuration.spec.MessagingPropsCfg;
import smecalculus.bezmen.validation.spec.BezmenValidator;

public record MessagingConfigImpl(
        @NonNull ConfigKeeper keeper, @NonNull BezmenValidator validator, @NonNull MessagingCfgMapper mapper)
        implements MessagingConfig {

    private static final Logger LOG = LoggerFactory.getLogger(MessagingConfigImpl.class);

    @Override
    public MessagingProps getMessagingProps() {
        MessagingPropsCfg propsCfg = keeper.read("bezmen.messaging", MessagingPropsCfg.class);
        validator.validate(propsCfg);
        LOG.info("Read {}", propsCfg);
        return mapper.toDomain(propsCfg);
    }
}
