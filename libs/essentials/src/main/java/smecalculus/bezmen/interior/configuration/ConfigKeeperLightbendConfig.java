package smecalculus.bezmen.interior.configuration;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigBeanFactory;

public record ConfigKeeperLightbendConfig(Config config) implements ConfigKeeper {

    @Override
    public <T> T read(String key, Class<T> type) {
        return ConfigBeanFactory.create(config.getConfig(key), type);
    }
}
