package smecalculus.bezmen.interior.configuration;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.core.env.Environment;

@RequiredArgsConstructor
public class ConfigKeeperSpringConfig implements ConfigKeeper {

    @NonNull
    private Environment environment;

    @Override
    public <T> T read(String key, Class<T> type) {
        Binder binder = Binder.get(environment);
        return binder.bind(key, type).get();
    }
}
