package smecalculus.bezmen.interior.construction;

import org.springframework.test.context.TestPropertySource;

@TestPropertySource(properties = {"bezmen.config.mapping.mode=lightbend_config"})
class MessagingConfigBeansLightbendConfigIT extends MessagingConfigBeansIT {}
