package smecalculus.bezmen.construction;

import static org.springframework.context.annotation.ConfigurationCondition.ConfigurationPhase.REGISTER_BEAN;

import lombok.NonNull;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.ConfigurationCondition;
import org.springframework.core.type.AnnotatedTypeMetadata;
import smecalculus.bezmen.configuration.StateMappingMode;
import smecalculus.bezmen.configuration.StorageProps;

class StateMappingModeCondition implements ConfigurationCondition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        var attributes = metadata.getAnnotationAttributes(ConditionalOnStateMappingMode.class.getName());
        var mode = (StateMappingMode) attributes.get("value");
        var props = context.getBeanFactory().getBean(StorageProps.class);
        return mode == props.mappingProps().mappingMode();
    }

    @Override
    public @NonNull ConfigurationPhase getConfigurationPhase() {
        return REGISTER_BEAN;
    }
}