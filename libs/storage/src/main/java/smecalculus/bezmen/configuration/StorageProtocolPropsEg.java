package smecalculus.bezmen.configuration;

public class StorageProtocolPropsEg {
    public static class Pojos {
        public static StorageProtocolPropsCfg storageProtocolPropsCfg() {
            StorageProtocolPropsCfg propsCfg = new StorageProtocolPropsCfg();
            propsCfg.setMode(StorageProtocolMode.H2.name());
            return propsCfg;
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
                    .postgresProps(null);
        }
    }
}
