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
                .protocolProps(protocolProps().build())
                .mappingProps(mappingProps().build());
    }

    public static StorageProps.Builder storageProps(StorageMappingMode mappingMode, StorageProtocolMode protocolMode) {
        return storageProps()
                .protocolProps(protocolProps(protocolMode).build())
                .mappingProps(mappingProps(mappingMode).build());
    }

    public static MappingProps.Builder mappingProps() {
        return MappingProps.builder().mappingMode(SPRING_DATA);
    }

    public static MappingProps.Builder mappingProps(StorageMappingMode mode) {
        return mappingProps().mappingMode(mode);
    }

    public static ProtocolProps.Builder protocolProps() {
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

    public static ProtocolProps.Builder protocolProps(StorageProtocolMode mode) {
        return protocolProps().protocolMode(mode);
    }
}
