package smecalculus.bezmen.configuration;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static smecalculus.bezmen.fixture.DataPropsFixture.dataPropsCfg;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import smecalculus.bezmen.configuration.impl.DataConfigImpl;
import smecalculus.bezmen.configuration.spec.ConfigKeeper;
import smecalculus.bezmen.configuration.spec.DataCfgMapperImpl;
import smecalculus.bezmen.configuration.spec.DataConfig;
import smecalculus.bezmen.configuration.spec.DataPropsCfg;
import smecalculus.bezmen.validation.spec.BezmenValidator;

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
