package smecalculus.bezmen.configuration;

import static smecalculus.bezmen.configuration.StateMappingPropsEg.Builders.stateMappingProps;
import static smecalculus.bezmen.configuration.StateMappingPropsEg.Pojos.stateMappingPropsEdge;
import static smecalculus.bezmen.configuration.StorageProtocolPropsEg.Builders.storageProtocolProps;
import static smecalculus.bezmen.configuration.StorageProtocolPropsEg.Pojos.storageProtocolPropsEdge;

public class StoragePropsEg {
    public static class Pojos {
        public static StoragePropsEdge storagePropsEdge() {
            StoragePropsEdge propsEdge = new StoragePropsEdge();
            propsEdge.setProtocol(storageProtocolPropsEdge());
            propsEdge.setMapping(stateMappingPropsEdge());
            return propsEdge;
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
