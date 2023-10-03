package smecalculus.bezmen.construction;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static smecalculus.bezmen.configuration.StoragePropsEg.Pojos.storagePropsCfg;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import smecalculus.bezmen.configuration.ConfigKeeper;
import smecalculus.bezmen.configuration.StorageCfgMapper;
import smecalculus.bezmen.configuration.StorageCfgMapperImpl;
import smecalculus.bezmen.configuration.StoragePropsCfg;
import smecalculus.bezmen.validation.EdgeValidator;

class StorageConfigBeansTest {

    private StorageConfigBeans configBeans;
    private EdgeValidator validatorMock;
    private ConfigKeeper keeperMock;
    private StorageCfgMapper mapper;

    @BeforeEach
    void setUp() {
        configBeans = new StorageConfigBeans();
        validatorMock = mock(EdgeValidator.class);
        keeperMock = mock(ConfigKeeper.class);
        mapper = new StorageCfgMapperImpl();
    }

    @Test
    void shouldValidateConf() {
        // given
        StoragePropsCfg expectedStorageProps = storagePropsCfg();
        // and
        when(keeperMock.read("bezmen.storage", StoragePropsCfg.class)).thenReturn(expectedStorageProps);
        // when
        configBeans.storageProps(keeperMock, validatorMock, mapper);
        // then
        verify(validatorMock).validate(expectedStorageProps);
    }
}
