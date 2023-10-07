package smecalculus.bezmen.interior.construction;

import static org.springframework.context.annotation.ConfigurationCondition.ConfigurationPhase.REGISTER_BEAN;

import java.util.Map;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.ConfigurationCondition;
import org.springframework.core.type.AnnotatedTypeMetadata;
import smecalculus.bezmen.interior.configuration.StateMappingMode;
import smecalculus.bezmen.interior.configuration.StorageProps;

class StateMappingModeCondition implements ConfigurationCondition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Map<String, Object> attributes =
                metadata.getAnnotationAttributes(ConditionalOnStateMappingMode.class.getName());
        StateMappingMode mode = (StateMappingMode) attributes.get("value");
        StorageProps props = context.getBeanFactory().getBean(StorageProps.class);
        return mode == props.mappingProps().mappingMode();
    }

    @Override
    public ConfigurationPhase getConfigurationPhase() {
        return REGISTER_BEAN;
    }
}
