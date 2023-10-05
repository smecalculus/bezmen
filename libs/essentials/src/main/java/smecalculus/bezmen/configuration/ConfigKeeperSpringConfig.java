package smecalculus.bezmen.configuration;

import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.core.env.Environment;

public record ConfigKeeperSpringConfig(Environment environment) implements ConfigKeeper {

    @Override
    public <T> T read(String key, Class<T> type) {
        Binder binder = Binder.get(environment);
        return binder.bind(key, type).get();
    }
}
