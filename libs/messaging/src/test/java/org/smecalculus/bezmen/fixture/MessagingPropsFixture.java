package org.smecalculus.bezmen.fixture;

import static org.smecalculus.bezmen.fixture.ProtocolPropsFixture.protocolProps;

import org.smecalculus.bezmen.configuration.MessagingProps;

public class MessagingPropsFixture {
    public static MessagingProps.Builder messagingProps() {
        return MessagingProps.builder().protocolProps(protocolProps().build());
    }
}
