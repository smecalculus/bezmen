package smecalculus.bezmen.construction;

import static org.assertj.core.api.Assertions.assertThat;
import static smecalculus.bezmen.configuration.StoragePropsEg.Builders.storageProps;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import smecalculus.bezmen.configuration.StorageProps;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ConfigBeans.class, ValidationBeans.class, StorageConfigBeans.class})
class StorageConfigBeansIT {

    @Test
    void defaultConfigShouldBeBackwardCompatible(@Autowired StorageProps actualProps) {
        // given
        StorageProps expectedProps = storageProps().build();
        // when
        // construction
        // then
        assertThat(actualProps).isEqualTo(expectedProps);
    }
}
