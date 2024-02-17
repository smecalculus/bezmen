package smecalculus.bezmen.construction;

import org.springframework.test.context.TestPropertySource;

@TestPropertySource(properties = {"product.config.mapping.mode=spring_config"})
class StorageConfigBeansSpringConfigIT extends StorageConfigBeansIT {}
