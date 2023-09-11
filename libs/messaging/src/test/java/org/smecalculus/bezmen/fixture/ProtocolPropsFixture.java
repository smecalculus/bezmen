package org.smecalculus.bezmen.fixture;

import static org.smecalculus.bezmen.configuration.spec.MessagingProtocol.HTTP;
import static org.smecalculus.bezmen.fixture.HttpPropsFixture.httpProps;

import java.util.Set;
import org.smecalculus.bezmen.configuration.spec.ProtocolProps;

public class ProtocolPropsFixture {
    public static ProtocolProps.Builder protocolProps() {
        return ProtocolProps.builder().types(Set.of(HTTP)).httpProps(httpProps().build());
    }
}
