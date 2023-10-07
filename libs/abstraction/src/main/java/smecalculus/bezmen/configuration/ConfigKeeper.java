package smecalculus.bezmen.configuration;

public interface ConfigKeeper {
    <T> T read(String key, Class<T> type);
}
