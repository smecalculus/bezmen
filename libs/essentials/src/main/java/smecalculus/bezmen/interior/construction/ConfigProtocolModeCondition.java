package smecalculus.bezmen.interior.construction;

import static org.springframework.context.annotation.ConfigurationCondition.ConfigurationPhase.REGISTER_BEAN;

import java.util.Map;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.ConfigurationCondition;
import org.springframework.core.type.AnnotatedTypeMetadata;
import smecalculus.bezmen.interior.configuration.ConfigProtocolMode;

class ConfigProtocolModeCondition implements ConfigurationCondition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Map<String, Object> attributes =
                metadata.getAnnotationAttributes(ConditionalOnConfigProtocolMode.class.getName());
        ConfigProtocolMode expectedMode = (ConfigProtocolMode) attributes.get("value");
        String actualMode = context.getEnvironment()
                .getProperty("bezmen.config.protocol.mode", ConfigProtocolMode.FILE_SYSTEM.name());
        return expectedMode.name().equalsIgnoreCase(actualMode);
    }

    @Override
    public ConfigurationPhase getConfigurationPhase() {
        return REGISTER_BEAN;
    }
}
