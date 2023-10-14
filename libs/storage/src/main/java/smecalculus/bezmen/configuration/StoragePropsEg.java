package smecalculus.bezmen.configuration;

import static smecalculus.bezmen.configuration.StateMappingPropsEg.Builders.stateMappingProps;
import static smecalculus.bezmen.configuration.StateMappingPropsEg.Pojos.stateMappingPropsCfg;
import static smecalculus.bezmen.configuration.StorageProtocolPropsEg.Builders.storageProtocolProps;
import static smecalculus.bezmen.configuration.StorageProtocolPropsEg.Pojos.storageProtocolPropsCfg;

public class StoragePropsEg {
    public static class Pojos {
        public static StoragePropsCfg storagePropsCfg() {
            StoragePropsCfg propsCfg = new StoragePropsCfg();
            propsCfg.setProtocol(storageProtocolPropsCfg());
            propsCfg.setMapping(stateMappingPropsCfg());
            return propsCfg;
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
