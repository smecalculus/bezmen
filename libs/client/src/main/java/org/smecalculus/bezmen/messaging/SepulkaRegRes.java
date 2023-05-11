package org.smecalculus.bezmen.messaging;

import java.util.UUID;
import lombok.NonNull;

public record SepulkaRegRes(@NonNull UUID id, @NonNull String name) {}
