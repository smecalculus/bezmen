package smecalculus.bezmen.construction;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import smecalculus.bezmen.configuration.ConfigKeeper;
import smecalculus.bezmen.configuration.StorageCfgMapper;
import smecalculus.bezmen.configuration.StorageCfgMapperImpl;
import smecalculus.bezmen.configuration.StorageConfig;
import smecalculus.bezmen.configuration.StorageConfigImpl;
import smecalculus.bezmen.configuration.StorageProps;
import smecalculus.bezmen.validation.EdgeValidator;

@Configuration(proxyBeanMethods = false)
public class StorageConfigBeans {

    @Bean
    StorageCfgMapper storageCfgMapper() {
        return new StorageCfgMapperImpl();
    }

    @Bean
    StorageConfig storageConfig(ConfigKeeper keeper, EdgeValidator validator, StorageCfgMapper mapper) {
        return new StorageConfigImpl(keeper, validator, mapper);
    }

    @Bean
    StorageProps storageProps(StorageConfig config) {
        return config.getStorageProps();
    }
}
