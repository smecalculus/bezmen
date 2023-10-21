package smecalculus.bezmen.configuration;

import com.typesafe.config.Optional;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;
import smecalculus.bezmen.validation.ValueOfEnum;

public abstract class StorageEdge {
    @Data
    public static class StorageProps {
        @NotNull
        ProtocolProps protocol;

        @NotNull
        MappingProps mapping;
    }

    @Data
    public static class ProtocolProps {
        @ValueOfEnum(StorageProtocolMode.class)
        String mode;

        @Optional
        H2Props h2;

        @Optional
        PostgresProps postgres;
    }

    @Data
    public static class MappingProps {
        @ValueOfEnum(StorageMappingMode.class)
        private String mode;
    }

    @Data
    public static class PostgresProps {
        @NotBlank
        String url;

        @NotBlank
        String username;

        @NotBlank
        @ToString.Exclude
        String password;
    }

    @Data
    public static class H2Props {
        @NotBlank
        String url;

        @NotBlank
        String username;

        @NotBlank
        String password;
    }
}
