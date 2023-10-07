package smecalculus.bezmen.interior.configuration;

public interface ConfigKeeper {
    <T> T read(String key, Class<T> type);
}
