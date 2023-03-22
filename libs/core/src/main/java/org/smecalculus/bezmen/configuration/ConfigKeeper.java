package org.smecalculus.bezmen.configuration;

interface ConfigKeeper {
    <T> T read(String key, Class<T> type);
}
