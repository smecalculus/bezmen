package smecalculus.bezmen.construction;

import static java.util.Objects.requireNonNull;
import static org.springframework.context.annotation.ConfigurationCondition.ConfigurationPhase.REGISTER_BEAN;

import lombok.NonNull;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.ConfigurationCondition;
import org.springframework.core.type.AnnotatedTypeMetadata;
import smecalculus.bezmen.configuration.ValidationDm.ValidationMode;
import smecalculus.bezmen.configuration.ValidationDm.ValidationProps;

class ValidationModeCondition implements ConfigurationCondition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        var attributes = metadata.getAnnotationAttributes(ConditionalOnValidationMode.class.getName());
        var mode = (ValidationMode) requireNonNull(attributes).get("value");
        var props = requireNonNull(context.getBeanFactory()).getBean(ValidationProps.class);
        return mode == props.validationMode();
    }

    @Override
    public @NonNull ConfigurationPhase getConfigurationPhase() {
        return REGISTER_BEAN;
    }
}
