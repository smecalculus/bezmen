package smecalculus.bezmen.configuration.spec;

public interface ConfigKeeper {
    <T> T read(String key, Class<T> type);
}
