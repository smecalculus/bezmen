package smecalculus.bezmen.fixture;

import static smecalculus.bezmen.fixture.ProtocolPropsFixture.protocolProps;

import smecalculus.bezmen.configuration.spec.MessagingProps;

public class MessagingPropsFixture {
    public static MessagingProps.Builder messagingProps() {
        return MessagingProps.builder().protocolProps(protocolProps().build());
    }
}
