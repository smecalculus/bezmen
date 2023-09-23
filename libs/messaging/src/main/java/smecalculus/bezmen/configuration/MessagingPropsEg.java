package smecalculus.bezmen.configuration;

import static smecalculus.bezmen.configuration.ProtocolPropsEg.Builders.protocolProps;

public class MessagingPropsEg {
    public static class Builders {
        public static MessagingProps.Builder messagingProps() {
            return MessagingProps.builder().protocolProps(protocolProps().build());
        }
    }
}
