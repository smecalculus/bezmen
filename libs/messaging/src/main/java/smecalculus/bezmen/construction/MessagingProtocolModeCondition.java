package smecalculus.bezmen.construction;

import static org.springframework.context.annotation.ConfigurationCondition.ConfigurationPhase.REGISTER_BEAN;

import java.util.stream.Stream;
import lombok.NonNull;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.ConfigurationCondition;
import org.springframework.core.type.AnnotatedTypeMetadata;
import smecalculus.bezmen.configuration.MessagingProps;
import smecalculus.bezmen.configuration.MessagingProtocolMode;

class MessagingProtocolModeCondition implements ConfigurationCondition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        var attributes = metadata.getAnnotationAttributes(ConditionalOnMessagingProtocolModes.class.getName());
        var expectedModes = (MessagingProtocolMode[]) attributes.get("value");
        var props = context.getBeanFactory().getBean(MessagingProps.class);
        var actualModes = props.protocolProps().protocolModes();
        return Stream.of(expectedModes).anyMatch(actualModes::contains);
    }

    @Override
    public @NonNull ConfigurationPhase getConfigurationPhase() {
        return REGISTER_BEAN;
    }
}
