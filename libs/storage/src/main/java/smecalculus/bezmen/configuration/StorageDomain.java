package smecalculus.bezmen.configuration;

import lombok.Builder;
import lombok.NonNull;
import lombok.ToString;

public abstract class StorageDomain {
    @Builder
    public record StorageProps(@NonNull ProtocolProps protocolProps, @NonNull MappingProps mappingProps) {}

    @Builder
    public record ProtocolProps(
            @NonNull StorageProtocolMode protocolMode, H2Props h2Props, PostgresProps postgresProps) {}

    @Builder
    public record MappingProps(@NonNull StorageMappingMode mappingMode) {}

    @Builder
    public record H2Props(@NonNull String url, @NonNull String username, @NonNull String password) {}

    @Builder
    public record PostgresProps(
            @NonNull String url, @NonNull String username, @NonNull @ToString.Exclude String password) {}
}
