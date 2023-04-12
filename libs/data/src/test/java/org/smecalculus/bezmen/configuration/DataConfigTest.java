package org.smecalculus.bezmen.configuration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.smecalculus.bezmen.modeling.DataConfig;
import org.smecalculus.bezmen.validation.BezmenValidator;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.smecalculus.bezmen.fixture.DataPropsFixture.dataPropsCfg;

@ExtendWith(MockitoExtension.class)
abstract class DataConfigTest {

    private DataConfig dataConfig;

    @Mock
    private BezmenValidator validator;
    @Mock
    private ConfigKeeper keeper;

    @BeforeEach
    void setUp() {
        dataConfig = new DataConfigImpl(keeper, validator, new DataCfgMapperImpl());
    }

    @Test
    void shouldValidateConf() {
        // given
        DataPropsCfg expectedDataProps = dataPropsCfg();
        // and
        when(keeper.read("bezmen.data", DataPropsCfg.class)).thenReturn(expectedDataProps);
        // when
        dataConfig.getDataProps();
        // then
        verify(validator).validate(expectedDataProps);
    }
}