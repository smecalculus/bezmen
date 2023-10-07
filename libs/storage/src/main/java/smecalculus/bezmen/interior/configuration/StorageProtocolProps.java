package smecalculus.bezmen.interior.configuration;

import lombok.Builder;
import lombok.NonNull;

@Builder
public record StorageProtocolProps(
        @NonNull StorageProtocolMode protocolMode, H2Props h2Props, PostgresProps postgresProps) {}
