package smecalculus.bezmen.configuration;

import lombok.Builder;
import lombok.NonNull;
import org.springframework.lang.Nullable;

@Builder
public record StorageProtocolProps(
        @NonNull StorageProtocolMode protocolMode, @Nullable H2Props h2Props, @Nullable PostgresProps postgresProps) {}
