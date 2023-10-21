package smecalculus.bezmen.configuration;

import static smecalculus.bezmen.configuration.MessagingMappingMode.SPRING_MVC;
import static smecalculus.bezmen.configuration.MessagingProtocolMode.HTTP;

import java.util.Set;
import smecalculus.bezmen.configuration.MessagingDomain.MappingProps;
import smecalculus.bezmen.configuration.MessagingDomain.MessagingProps;
import smecalculus.bezmen.configuration.MessagingDomain.ProtocolProps;

public abstract class MessagingDomainEg {
    public static MessagingProps.Builder messagingProps() {
        return MessagingProps.builder()
                .protocolProps(protocolProps().build())
                .mappingProps(mappingProps().build());
    }

    public static ProtocolProps.Builder protocolProps() {
        return MessagingDomain.ProtocolProps.builder().protocolModes(Set.of(HTTP));
    }

    public static MappingProps.Builder mappingProps() {
        return MappingProps.builder().mappingModes(Set.of(SPRING_MVC));
    }
}
