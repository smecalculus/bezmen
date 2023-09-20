package smecalculus.bezmen.fixture;

import static smecalculus.bezmen.configuration.spec.MessagingProtocol.HTTP;
import static smecalculus.bezmen.fixture.HttpPropsFixture.httpProps;

import java.util.Set;
import smecalculus.bezmen.configuration.spec.ProtocolProps;

public class ProtocolPropsFixture {
    public static ProtocolProps.Builder protocolProps() {
        return ProtocolProps.builder().types(Set.of(HTTP)).httpProps(httpProps().build());
    }
}
