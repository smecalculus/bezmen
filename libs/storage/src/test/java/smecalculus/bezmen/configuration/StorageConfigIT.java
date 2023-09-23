package smecalculus.bezmen.configuration;

import static org.assertj.core.api.Assertions.assertThat;
import static smecalculus.bezmen.configuration.StoragePropsEg.Builders.storageProps;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import smecalculus.bezmen.construction.ConfigBeans;
import smecalculus.bezmen.construction.StorageConfigBeans;
import smecalculus.bezmen.construction.ValidationBeans;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ConfigBeans.class, ValidationBeans.class, StorageConfigBeans.class})
abstract class StorageConfigIT {

    @Autowired
    StorageConfig storageConfig;

    @Test
    void defaultConfShouldBeBackwardCompatible() {
        // given
        StorageProps expectedStorageProps = storageProps().build();
        // when
        StorageProps actualStorageProps = storageConfig.getStorageProps();
        // then
        assertThat(actualStorageProps).isEqualTo(expectedStorageProps);
    }
}
