package smecalculus.bezmen.interior.configuration;

import static smecalculus.bezmen.interior.configuration.StateMappingPropsEg.Builders.stateMappingProps;
import static smecalculus.bezmen.interior.configuration.StateMappingPropsEg.Pojos.stateMappingPropsCfg;
import static smecalculus.bezmen.interior.configuration.StorageProtocolPropsEg.Builders.storageProtocolProps;
import static smecalculus.bezmen.interior.configuration.StorageProtocolPropsEg.Pojos.storageProtocolPropsCfg;

public class StoragePropsEg {
    public static class Pojos {
        public static StoragePropsCfg storagePropsCfg() {
            StoragePropsCfg storagePropsCfg = new StoragePropsCfg();
            storagePropsCfg.setProtocol(storageProtocolPropsCfg());
            storagePropsCfg.setMapping(stateMappingPropsCfg());
            return storagePropsCfg;
        }
    }

    public static class Builders {
        public static StorageProps.Builder storageProps() {
            return StorageProps.builder()
                    .protocolProps(storageProtocolProps().build())
                    .mappingProps(stateMappingProps().build());
        }
    }
}