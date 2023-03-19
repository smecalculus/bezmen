package org.smecalculus.bezmen.configuration;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.smecalculus.bezmen.core.validation.BezmenValidator;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.smecalculus.bezmen.fixture.DataPropsFixtures.dataPropsMap;

@ExtendWith(MockitoExtension.class)
abstract class DataConfigTest {

    private DataConfig dataConfig;

    @Mock
    private BezmenValidator validator;
    @Mock
    private Config globalConfig;

    @Test
    void shouldValidateConfig() {
        // given
        Config localConfig = ConfigFactory.parseMap(dataPropsMap());
        when(globalConfig.getConfig("bezmen.data")).thenReturn(localConfig);
        dataConfig = new DataConfigLightbendConfig(globalConfig, validator, new DataMapperImpl());
        // when
        dataConfig.getDataProps();
        // then
        verify(validator).validate(any(DataPropsDTO.class));
    }
}