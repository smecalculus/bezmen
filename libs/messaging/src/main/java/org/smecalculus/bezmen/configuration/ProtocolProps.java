package org.smecalculus.bezmen.configuration;

import edu.umd.cs.findbugs.annotations.Nullable;
import java.util.Set;
import lombok.Builder;
import lombok.NonNull;

@Builder
public record ProtocolProps(@NonNull Set<MessagingProtocol> types, @Nullable HttpProps httpProps) {}
