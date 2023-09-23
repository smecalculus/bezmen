package smecalculus.bezmen.configuration;

import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import smecalculus.bezmen.validation.EdgeValidator;

public record StorageConfigImpl(
        @NonNull ConfigKeeper configKeeper, @NonNull EdgeValidator validator, @NonNull StorageCfgMapper mapper)
        implements StorageConfig {

    private static final Logger LOG = LoggerFactory.getLogger(StorageConfigImpl.class);

    @Override
    public StorageProps getStorageProps() {
        StoragePropsCfg propsCfg = configKeeper.read("bezmen.storage", StoragePropsCfg.class);
        validator.validate(propsCfg);
        LOG.info("Read {}", propsCfg);
        return mapper.toDomain(propsCfg);
    }
}
