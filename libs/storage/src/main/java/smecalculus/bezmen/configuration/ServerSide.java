package smecalculus.bezmen.configuration;

import lombok.Builder;
import lombok.NonNull;
import lombok.ToString;

public abstract class ServerSide {

    @Builder
    public record StorageProps(@NonNull StorageProtocolProps protocolProps, @NonNull StateMappingProps mappingProps) {}

    @Builder
    public record StorageProtocolProps(
            @NonNull StorageProtocolMode protocolMode, H2Props h2Props, PostgresProps postgresProps) {}

    @Builder
    public record StateMappingProps(@NonNull StateMappingMode mappingMode) {}

    @Builder
    public record H2Props(@NonNull String url, @NonNull String username, @NonNull String password) {}

    @Builder
    public record PostgresProps(
            @NonNull String url, @NonNull String username, @NonNull @ToString.Exclude String password) {}
}
