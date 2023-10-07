package smecalculus.bezmen.interior.construction;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static smecalculus.bezmen.interior.configuration.StoragePropsEg.Pojos.storagePropsCfg;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import smecalculus.bezmen.interior.configuration.ConfigKeeper;
import smecalculus.bezmen.interior.configuration.StorageCfgMapper;
import smecalculus.bezmen.interior.configuration.StorageCfgMapperImpl;
import smecalculus.bezmen.interior.configuration.StoragePropsCfg;
import smecalculus.bezmen.interior.validation.EdgeValidator;

class StorageConfigBeansTest {

    private final StorageConfigBeans config = new StorageConfigBeans();
    private final StorageCfgMapper mapper = new StorageCfgMapperImpl();
    private EdgeValidator validatorMock;
    private ConfigKeeper keeperMock;

    @BeforeEach
    void setUp() {
        validatorMock = mock(EdgeValidator.class);
        keeperMock = mock(ConfigKeeper.class);
    }

    @Test
    void shouldValidateConf() {
        // given
        StoragePropsCfg expectedProps = storagePropsCfg();
        // and
        when(keeperMock.read("bezmen.storage", StoragePropsCfg.class)).thenReturn(expectedProps);
        // when
        config.storageProps(keeperMock, validatorMock, mapper);
        // then
        verify(validatorMock).validate(expectedProps);
    }
}
