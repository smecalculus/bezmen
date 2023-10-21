package smecalculus.bezmen.configuration;

import static smecalculus.bezmen.configuration.StorageMappingMode.SPRING_DATA;
import static smecalculus.bezmen.configuration.StorageProtocolMode.H2;

import smecalculus.bezmen.configuration.StorageEdge.MappingProps;
import smecalculus.bezmen.configuration.StorageEdge.ProtocolProps;
import smecalculus.bezmen.configuration.StorageEdge.StorageProps;

public abstract class StorageEdgeEg {
    public static StorageProps storageProps() {
        var propsEdge = new StorageProps();
        propsEdge.setMapping(stateMappingProps());
        propsEdge.setProtocol(storageProtocolProps());
        return propsEdge;
    }

    public static MappingProps stateMappingProps() {
        var propsEdge = new StorageEdge.MappingProps();
        propsEdge.setMode(SPRING_DATA.name());
        return propsEdge;
    }

    public static ProtocolProps storageProtocolProps() {
        var propsEdge = new ProtocolProps();
        propsEdge.setMode(H2.name());
        return propsEdge;
    }
}
