package org.smecalculus.bezmen.fixture;

import org.smecalculus.bezmen.configuration.MessagingProps;

import static org.smecalculus.bezmen.fixture.ProtocolPropsFixture.protocolProps;

public class MessagingPropsFixture {
    public static MessagingProps.Builder messagingProps() {
        return MessagingProps.builder()
                .protocolProps(protocolProps().build());
    }
}
