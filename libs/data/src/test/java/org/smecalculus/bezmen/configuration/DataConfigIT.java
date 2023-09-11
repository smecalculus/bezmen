package org.smecalculus.bezmen.configuration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.smecalculus.bezmen.fixture.DataPropsFixture.dataProps;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.smecalculus.bezmen.configuration.spec.DataConfig;
import org.smecalculus.bezmen.configuration.spec.DataProps;
import org.smecalculus.bezmen.construction.spec.ConfigBeans;
import org.smecalculus.bezmen.construction.spec.DataConfigBeans;
import org.smecalculus.bezmen.construction.spec.ValidationBeans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ConfigBeans.class, ValidationBeans.class, DataConfigBeans.class})
abstract class DataConfigIT {

    @Autowired
    DataConfig dataConfig;

    @Test
    void defaultConfShouldBeBackwardCompatible() {
        // given
        DataProps expectedDataProps = dataProps().build();
        // when
        DataProps actualDataProps = dataConfig.getDataProps();
        // then
        assertThat(actualDataProps).isEqualTo(expectedDataProps);
    }
}
