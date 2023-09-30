package smecalculus.bezmen.configuration;

import static smecalculus.bezmen.configuration.MessagingProtocolPropsEg.Builders.messagingProtocolProps;

public class MessagingPropsEg {
    public static class Builders {
        public static MessagingProps.Builder messagingProps() {
            return MessagingProps.builder()
                    .protocolProps(messagingProtocolProps().build());
        }
    }
}
