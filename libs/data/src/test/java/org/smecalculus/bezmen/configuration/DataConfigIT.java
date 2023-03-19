package org.smecalculus.bezmen.configuration;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.smecalculus.bezmen.fixture.DataPropsFixtures.dataPropsPojo;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = DataConfigBeans.class)
abstract class DataConfigIT {

    @Autowired
    private DataConfig dataConfig;

    @Test
    void shouldReadDefaultConfig() {
        // given
        DataProps expectedDataProps = dataPropsPojo().build();
        // when
        DataProps actualDataProps = dataConfig.getDataProps();
        // then
        assertThat(actualDataProps).isEqualTo(expectedDataProps);
    }
}
