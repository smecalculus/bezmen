package smecalculus.bezmen.fixture;

import static smecalculus.bezmen.configuration.MessagingProtocol.HTTP;
import static smecalculus.bezmen.fixture.HttpPropsFixture.httpProps;

import java.util.Set;
import smecalculus.bezmen.configuration.ProtocolProps;

public class ProtocolPropsFixture {
    public static ProtocolProps.Builder protocolProps() {
        return ProtocolProps.builder().types(Set.of(HTTP)).httpProps(httpProps().build());
    }
}
