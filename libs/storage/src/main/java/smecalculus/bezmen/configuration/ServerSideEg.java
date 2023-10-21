package smecalculus.bezmen.configuration;

import static smecalculus.bezmen.configuration.StateMappingMode.SPRING_DATA;
import static smecalculus.bezmen.configuration.StorageProtocolMode.H2;

import smecalculus.bezmen.configuration.ServerSide.H2Props;
import smecalculus.bezmen.configuration.ServerSide.PostgresProps;
import smecalculus.bezmen.configuration.ServerSide.StateMappingProps;
import smecalculus.bezmen.configuration.ServerSide.StorageProps;
import smecalculus.bezmen.configuration.ServerSide.StorageProtocolProps;

public abstract class ServerSideEg {
    public static StorageProps.Builder storageProps() {
        return StorageProps.builder()
                .protocolProps(storageProtocolProps().build())
                .mappingProps(stateMappingProps().build());
    }

    public static StorageProps.Builder storageProps(StateMappingMode mappingMode, StorageProtocolMode protocolMode) {
        return storageProps()
                .protocolProps(storageProtocolProps(protocolMode).build())
                .mappingProps(stateMappingProps(mappingMode).build());
    }

    public static StateMappingProps.Builder stateMappingProps() {
        return StateMappingProps.builder().mappingMode(SPRING_DATA);
    }

    public static StateMappingProps.Builder stateMappingProps(StateMappingMode mode) {
        return stateMappingProps().mappingMode(mode);
    }

    public static StorageProtocolProps.Builder storageProtocolProps() {
        return StorageProtocolProps.builder()
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

    public static StorageProtocolProps.Builder storageProtocolProps(StorageProtocolMode mode) {
        return storageProtocolProps().protocolMode(mode);
    }
}
