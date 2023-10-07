package smecalculus.bezmen.interior.configuration;

import static smecalculus.bezmen.interior.configuration.MessagingProtocolMode.HTTP;

import java.util.Set;

public class MessagingProtocolPropsEg {
    public static class Builders {
        public static MessagingProtocolProps.Builder messagingProtocolProps() {
            return MessagingProtocolProps.builder().protocolModes(Set.of(HTTP));
        }
    }
}
