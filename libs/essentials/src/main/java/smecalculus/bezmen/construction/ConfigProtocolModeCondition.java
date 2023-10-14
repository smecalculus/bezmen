package smecalculus.bezmen.construction;

import static org.springframework.context.annotation.ConfigurationCondition.ConfigurationPhase.REGISTER_BEAN;

import java.util.Map;
import lombok.NonNull;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.ConfigurationCondition;
import org.springframework.core.type.AnnotatedTypeMetadata;
import smecalculus.bezmen.configuration.ConfigProtocolMode;

class ConfigProtocolModeCondition implements ConfigurationCondition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Map<String, Object> attributes =
                metadata.getAnnotationAttributes(ConditionalOnConfigProtocolMode.class.getName());
        var expectedMode = (ConfigProtocolMode) attributes.get("value");
        String actualMode = context.getEnvironment()
                .getProperty("bezmen.config.protocol.mode", ConfigProtocolMode.FILE_SYSTEM.name());
        return expectedMode.name().equalsIgnoreCase(actualMode);
    }

    @Override
    public @NonNull ConfigurationPhase getConfigurationPhase() {
        return REGISTER_BEAN;
    }
}