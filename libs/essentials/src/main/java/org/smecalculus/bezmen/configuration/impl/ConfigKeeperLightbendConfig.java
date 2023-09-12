package org.smecalculus.bezmen.configuration.impl;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigBeanFactory;
import org.smecalculus.bezmen.configuration.spec.ConfigKeeper;

public record ConfigKeeperLightbendConfig(Config config) implements ConfigKeeper {

    @Override
    public <T> T read(String key, Class<T> type) {
        return ConfigBeanFactory.create(config.getConfig(key), type);
    }
}
