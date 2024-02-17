package smecalculus.bezmen.construction;

import org.springframework.test.context.TestPropertySource;

@TestPropertySource(properties = {"product.config.mapping.mode=lightbend_config"})
class MessagingConfigBeansLightbendConfigIT extends MessagingConfigBeansIT {}
