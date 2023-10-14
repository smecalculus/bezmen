package smecalculus.bezmen.configuration;

public class StorageProtocolPropsEg {
    public static class Pojos {
        public static StorageProtocolPropsEdge storageProtocolPropsEdge() {
            var propsEdge = new StorageProtocolPropsEdge();
            propsEdge.setMode(StorageProtocolMode.H2.name());
            return propsEdge;
        }
    }

    public static class Builders {
        public static StorageProtocolProps.Builder storageProtocolProps() {
            return StorageProtocolProps.builder()
                    .protocolMode(StorageProtocolMode.H2)
                    .h2Props(H2Props.builder()
                            .url("jdbc:h2:mem:db;DB_CLOSE_DELAY=-1")
                            .username("sa")
                            .password("sa")
                            .build())
                    .postgresProps(PostgresProps.builder()
                            .url("jdbc:postgresql://localhost:5432/bezmen")
                            .username("bezmen")
                            .password("bezmen")
                            .build());
        }
    }
}
