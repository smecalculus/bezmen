package smecalculus.bezmen.configuration;

import static smecalculus.bezmen.configuration.HttpPropsEg.Builders.httpProps;
import static smecalculus.bezmen.configuration.MessagingProtocol.HTTP;

import java.util.Set;

public class ProtocolPropsEg {
    public static class Builders {
        public static ProtocolProps.Builder protocolProps() {
            return ProtocolProps.builder()
                    .types(Set.of(HTTP))
                    .httpProps(httpProps().build());
        }
    }
}
