package smecalculus.bezmen.interior.construction;

import static org.assertj.core.api.Assertions.assertThat;
import static smecalculus.bezmen.interior.configuration.MessagingPropsEg.Builders.messagingProps;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import smecalculus.bezmen.interior.configuration.MessagingProps;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {MessagingConfigBeans.class, ConfigBeans.class, ValidationBeans.class})
abstract class MessagingConfigBeansIT {

    @Test
    void defaultConfigShouldBeBackwardCompatible(@Autowired MessagingProps actualProps) {
        // given
        MessagingProps expectedProps = messagingProps().build();
        // when
        // default construction
        // then
        assertThat(actualProps).isEqualTo(expectedProps);
    }
}
