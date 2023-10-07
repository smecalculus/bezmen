package smecalculus.bezmen.interior.construction;

import static org.springframework.context.annotation.ConfigurationCondition.ConfigurationPhase.REGISTER_BEAN;

import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.ConfigurationCondition;
import org.springframework.core.type.AnnotatedTypeMetadata;
import smecalculus.bezmen.interior.configuration.MessagingProps;
import smecalculus.bezmen.interior.configuration.MessagingProtocolMode;

class MessagingProtocolModeCondition implements ConfigurationCondition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Map<String, Object> attributes =
                metadata.getAnnotationAttributes(ConditionalOnMessagingProtocolModes.class.getName());
        MessagingProtocolMode[] expectedModes = (MessagingProtocolMode[]) attributes.get("value");
        MessagingProps messagingProps = context.getBeanFactory().getBean(MessagingProps.class);
        Set<MessagingProtocolMode> actualModes = messagingProps.protocolProps().protocolModes();
        return Stream.of(expectedModes).anyMatch(actualModes::contains);
    }

    @Override
    public ConfigurationPhase getConfigurationPhase() {
        return REGISTER_BEAN;
    }
}
