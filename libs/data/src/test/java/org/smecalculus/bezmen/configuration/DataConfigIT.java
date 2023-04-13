package org.smecalculus.bezmen.configuration;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.smecalculus.bezmen.construction.CoreBeans;
import org.smecalculus.bezmen.construction.DataConfigBeans;
import org.smecalculus.bezmen.modeling.DataConfig;
import org.smecalculus.bezmen.modeling.DataProps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.smecalculus.bezmen.fixture.DataPropsFixture.dataProps;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {CoreBeans.class, DataConfigBeans.class})
abstract class DataConfigIT {

    @Autowired
    private DataConfig dataConfig;

    @Test
    void shouldReadDefaultConf() {
        // given
        DataProps expectedDataProps = dataProps().build();
        // when
        DataProps actualDataProps = dataConfig.getDataProps();
        // then
        assertThat(actualDataProps).isEqualTo(expectedDataProps);
    }
}
