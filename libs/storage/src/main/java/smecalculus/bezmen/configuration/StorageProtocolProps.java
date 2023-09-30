package smecalculus.bezmen.configuration;

import edu.umd.cs.findbugs.annotations.Nullable;
import lombok.Builder;
import lombok.NonNull;

@Builder
public record StorageProtocolProps(
        @NonNull StorageProtocolMode protocolMode, @Nullable H2Props h2Props, @Nullable PostgresProps postgresProps) {}
