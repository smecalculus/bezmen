package smecalculus.bezmen.construction;

import static org.assertj.core.api.Assertions.assertThat;
import static smecalculus.bezmen.configuration.MessagingPropsEg.Builders.messagingProps;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import smecalculus.bezmen.configuration.MessagingProps;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ConfigBeans.class, ValidationBeans.class, MessagingConfigBeans.class})
class MessagingConfigBeansIT {

    @Test
    void defaultConfigShouldBeBackwardCompatible(@Autowired MessagingProps actualProps) {
        // given
        MessagingProps expectedProps = messagingProps().build();
        // when
        // construction
        // then
        assertThat(actualProps).isEqualTo(expectedProps);
    }
}
