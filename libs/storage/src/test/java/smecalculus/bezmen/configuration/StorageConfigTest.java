package smecalculus.bezmen.configuration;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static smecalculus.bezmen.configuration.StoragePropsEg.Pojos.storagePropsCfg;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import smecalculus.bezmen.validation.EdgeValidator;

abstract class StorageConfigTest {

    private StorageConfig storageConfig;
    private EdgeValidator validatorMock;
    private ConfigKeeper keeperMock;

    @BeforeEach
    void setUp() {
        validatorMock = mock(EdgeValidator.class);
        keeperMock = mock(ConfigKeeper.class);
        storageConfig = new StorageConfigImpl(keeperMock, validatorMock, new StorageCfgMapperImpl());
    }

    @Test
    void shouldValidateConf() {
        // given
        StoragePropsCfg expectedStorageProps = storagePropsCfg();
        // and
        when(keeperMock.read("bezmen.storage", StoragePropsCfg.class)).thenReturn(expectedStorageProps);
        // when
        storageConfig.getStorageProps();
        // then
        verify(validatorMock).validate(expectedStorageProps);
    }
}
