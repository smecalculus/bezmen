package smecalculus.bezmen.configuration;

import lombok.NonNull;

public record ClientProps(@NonNull String host, @NonNull Integer port) {}
