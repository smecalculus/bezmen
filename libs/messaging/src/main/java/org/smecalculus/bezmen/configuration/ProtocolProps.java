package org.smecalculus.bezmen.configuration;

import edu.umd.cs.findbugs.annotations.Nullable;
import lombok.Builder;
import lombok.NonNull;

import java.util.Set;

@Builder
public record ProtocolProps(
        @NonNull Set<MessagingProtocol> types,
        @Nullable HttpProps httpProps
) {
}
