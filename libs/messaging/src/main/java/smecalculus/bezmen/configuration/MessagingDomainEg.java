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
                .protocolProps(messagingProtocolProps().build())
                .mappingProps(messageMappingProps().build());
    }

    public static ProtocolProps.Builder messagingProtocolProps() {
        return MessagingDomain.ProtocolProps.builder().protocolModes(Set.of(HTTP));
    }

    public static MappingProps.Builder messageMappingProps() {
        return MappingProps.builder().mappingModes(Set.of(SPRING_MVC));
    }
}
