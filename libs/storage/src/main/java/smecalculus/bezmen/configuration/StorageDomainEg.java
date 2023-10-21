package smecalculus.bezmen.configuration;

import static smecalculus.bezmen.configuration.StorageMappingMode.SPRING_DATA;
import static smecalculus.bezmen.configuration.StorageProtocolMode.H2;

import smecalculus.bezmen.configuration.StorageDomain.H2Props;
import smecalculus.bezmen.configuration.StorageDomain.MappingProps;
import smecalculus.bezmen.configuration.StorageDomain.PostgresProps;
import smecalculus.bezmen.configuration.StorageDomain.ProtocolProps;
import smecalculus.bezmen.configuration.StorageDomain.StorageProps;

public abstract class StorageDomainEg {
    public static StorageProps.Builder storageProps() {
        return StorageProps.builder()
                .protocolProps(storageProtocolProps().build())
                .mappingProps(stateMappingProps().build());
    }

    public static StorageProps.Builder storageProps(StorageMappingMode mappingMode, StorageProtocolMode protocolMode) {
        return storageProps()
                .protocolProps(storageProtocolProps(protocolMode).build())
                .mappingProps(stateMappingProps(mappingMode).build());
    }

    public static MappingProps.Builder stateMappingProps() {
        return MappingProps.builder().mappingMode(SPRING_DATA);
    }

    public static MappingProps.Builder stateMappingProps(StorageMappingMode mode) {
        return stateMappingProps().mappingMode(mode);
    }

    public static ProtocolProps.Builder storageProtocolProps() {
        return ProtocolProps.builder()
                .protocolMode(H2)
                .h2Props(H2Props.builder()
                        .url("jdbc:h2:mem:bezmen;DB_CLOSE_DELAY=-1")
                        .username("sa")
                        .password("sa")
                        .build())
                .postgresProps(PostgresProps.builder()
                        .url("jdbc:postgresql://localhost:5432/bezmen")
                        .username("bezmen")
                        .password("bezmen")
                        .build());
    }

    public static StorageDomain.ProtocolProps.Builder storageProtocolProps(StorageProtocolMode mode) {
        return storageProtocolProps().protocolMode(mode);
    }
}
