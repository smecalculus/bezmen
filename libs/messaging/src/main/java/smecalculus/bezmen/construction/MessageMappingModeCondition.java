package smecalculus.bezmen.construction;

import static org.springframework.context.annotation.ConfigurationCondition.ConfigurationPhase.REGISTER_BEAN;

import java.util.stream.Stream;
import lombok.NonNull;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.ConfigurationCondition;
import org.springframework.core.type.AnnotatedTypeMetadata;
import smecalculus.bezmen.configuration.MessagingDomain.MessagingProps;
import smecalculus.bezmen.configuration.MessagingMappingMode;

class MessageMappingModeCondition implements ConfigurationCondition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        var attributes = metadata.getAnnotationAttributes(ConditionalOnMessageMappingModes.class.getName());
        var expectedModes = (MessagingMappingMode[]) attributes.get("value");
        var props = context.getBeanFactory().getBean(MessagingProps.class);
        var actualModes = props.mappingProps().mappingModes();
        return Stream.of(expectedModes).anyMatch(actualModes::contains);
    }

    @Override
    public @NonNull ConfigurationPhase getConfigurationPhase() {
        return REGISTER_BEAN;
    }
}
