package smecalculus.bezmen.configuration;

import static org.assertj.core.api.Assertions.assertThat;
import static smecalculus.bezmen.fixture.DataPropsFixture.dataProps;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import smecalculus.bezmen.configuration.spec.DataConfig;
import smecalculus.bezmen.configuration.spec.DataProps;
import smecalculus.bezmen.construction.spec.ConfigBeans;
import smecalculus.bezmen.construction.spec.DataConfigBeans;
import smecalculus.bezmen.construction.spec.ValidationBeans;

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
