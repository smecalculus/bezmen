package smecalculus.bezmen.configuration;

import static smecalculus.bezmen.configuration.StateMappingMode.SPRING_DATA;
import static smecalculus.bezmen.configuration.StorageProtocolMode.H2;

import smecalculus.bezmen.configuration.EdgeSide.StateMappingProps;
import smecalculus.bezmen.configuration.EdgeSide.StorageProps;
import smecalculus.bezmen.configuration.EdgeSide.StorageProtocolProps;

public abstract class EdgeSideEg {

    public static StorageProps storageProps() {
        var propsEdge = new StorageProps();
        propsEdge.setMapping(stateMappingProps());
        propsEdge.setProtocol(storageProtocolProps());
        return propsEdge;
    }

    public static StateMappingProps stateMappingProps() {
        var propsEdge = new StateMappingProps();
        propsEdge.setMode(SPRING_DATA.name());
        return propsEdge;
    }

    public static StorageProtocolProps storageProtocolProps() {
        var propsEdge = new StorageProtocolProps();
        propsEdge.setMode(H2.name());
        return propsEdge;
    }
}
