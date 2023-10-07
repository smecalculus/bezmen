package smecalculus.bezmen.interior.construction;

import static org.assertj.core.api.Assertions.assertThat;
import static smecalculus.bezmen.interior.configuration.StoragePropsEg.Builders.storageProps;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import smecalculus.bezmen.interior.configuration.StorageProps;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {StorageConfigBeans.class, ConfigBeans.class, ValidationBeans.class})
abstract class StorageConfigBeansIT {

    @Test
    void defaultConfigShouldBeBackwardCompatible(@Autowired StorageProps actualProps) {
        // given
        StorageProps expectedProps = storageProps().build();
        // when
        // default construction
        // then
        assertThat(actualProps).isEqualTo(expectedProps);
    }
}
