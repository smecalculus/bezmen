package org.smecalculus.bezmen.configuration;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.smecalculus.bezmen.fixture.DataPropsFixture.dataPropsCfg;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.smecalculus.bezmen.modeling.DataConfig;
import org.smecalculus.bezmen.validation.BezmenValidator;

abstract class DataConfigTest {

    private DataConfig dataConfig;
    private BezmenValidator validatorMock;
    private ConfigKeeper keeperMock;

    @BeforeEach
    void setUp() {
        validatorMock = mock(BezmenValidator.class);
        keeperMock = mock(ConfigKeeper.class);
        dataConfig = new DataConfigImpl(keeperMock, validatorMock, new DataCfgMapperImpl());
    }

    @Test
    void shouldValidateConf() {
        // given
        DataPropsCfg expectedDataProps = dataPropsCfg();
        // and
        when(keeperMock.read("bezmen.data", DataPropsCfg.class)).thenReturn(expectedDataProps);
        // when
        dataConfig.getDataProps();
        // then
        verify(validatorMock).validate(expectedDataProps);
    }
}
