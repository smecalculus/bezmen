package smecalculus.bezmen.configuration;

import static org.assertj.core.api.Assertions.assertThat;
import static smecalculus.bezmen.configuration.MessagingPropsEg.Builders.messagingProps;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import smecalculus.bezmen.construction.ConfigBeans;
import smecalculus.bezmen.construction.MessagingConfigBeans;
import smecalculus.bezmen.construction.ValidationBeans;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ConfigBeans.class, ValidationBeans.class, MessagingConfigBeans.class})
abstract class MessagingConfigIT {

    @Autowired
    MessagingConfig messagingConfig;

    @Test
    void defaultConfigShouldBeBackwardCompatible() {
        // given
        MessagingProps expectedProps = messagingProps().build();
        // when
        MessagingProps actualProps = messagingConfig.getMessagingProps();
        // then
        assertThat(actualProps).isEqualTo(expectedProps);
    }
}
