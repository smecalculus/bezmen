package smecalculus.bezmen.interior.construction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import smecalculus.bezmen.interior.configuration.ConfigKeeper;
import smecalculus.bezmen.interior.configuration.StorageCfgMapper;
import smecalculus.bezmen.interior.configuration.StorageCfgMapperImpl;
import smecalculus.bezmen.interior.configuration.StorageProps;
import smecalculus.bezmen.interior.configuration.StoragePropsCfg;
import smecalculus.bezmen.interior.validation.EdgeValidator;

@PropertySource("classpath:storage.properties")
@Configuration(proxyBeanMethods = false)
public class StorageConfigBeans {

    private static final Logger LOG = LoggerFactory.getLogger(StorageConfigBeans.class);

    @Bean
    StorageCfgMapper storageCfgMapper() {
        return new StorageCfgMapperImpl();
    }

    @Bean
    StorageProps storageProps(ConfigKeeper keeper, EdgeValidator validator, StorageCfgMapper mapper) {
        StoragePropsCfg propsCfg = keeper.read("bezmen.storage", StoragePropsCfg.class);
        validator.validate(propsCfg);
        LOG.info("Read {}", propsCfg);
        return mapper.toDomain(propsCfg);
    }
}
