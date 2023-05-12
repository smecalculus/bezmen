package org.smecalculus.bezmen.configuration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.smecalculus.bezmen.fixture.MessagingPropsFixture.messagingProps;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.smecalculus.bezmen.construction.ConfigBeans;
import org.smecalculus.bezmen.construction.MessagingConfigBeans;
import org.smecalculus.bezmen.construction.ValidationBeans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ConfigBeans.class, ValidationBeans.class, MessagingConfigBeans.class})
abstract class MessagingConfigIT {

    @Autowired
    MessagingConfig messagingConfig;

    @Test
    void defaultConfShouldBeBackwardCompatible() {
        // given
        MessagingProps expectedMessagingProps = messagingProps().build();
        // when
        MessagingProps actualMessagingProps = messagingConfig.getMessagingProps();
        // then
        assertThat(actualMessagingProps).isEqualTo(expectedMessagingProps);
    }
}
