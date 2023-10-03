package smecalculus.bezmen.construction;

import static org.springframework.context.annotation.ConfigurationCondition.ConfigurationPhase.REGISTER_BEAN;

import java.util.Map;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.ConfigurationCondition;
import org.springframework.core.type.AnnotatedTypeMetadata;
import smecalculus.bezmen.configuration.ConfigMappingMode;

class ConfigMappingModeCondition implements ConfigurationCondition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Map<String, Object> attributes =
                metadata.getAnnotationAttributes(ConditionalOnConfigMappingMode.class.getName());
        ConfigMappingMode expectedMode = (ConfigMappingMode) attributes.get("value");
        String actualMode = System.getProperty("bezmen.config.mapping.mode", ConfigMappingMode.LIGHTBEND_CONFIG.name());
        return expectedMode.name().equalsIgnoreCase(actualMode);
    }

    @Override
    public ConfigurationPhase getConfigurationPhase() {
        return REGISTER_BEAN;
    }
}
