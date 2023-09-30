package smecalculus.bezmen.construction;

import static org.springframework.context.annotation.ConfigurationCondition.ConfigurationPhase.REGISTER_BEAN;

import java.util.Map;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.ConfigurationCondition;
import org.springframework.core.type.AnnotatedTypeMetadata;
import smecalculus.bezmen.configuration.MessagingProps;
import smecalculus.bezmen.configuration.MessagingProtocolMode;

class MessagingProtocolModeCondition implements ConfigurationCondition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Map<String, Object> attributes =
                metadata.getAnnotationAttributes(ConditionalOnMessagingProtocolMode.class.getName());
        MessagingProtocolMode mode = (MessagingProtocolMode) attributes.get("value");
        MessagingProps messagingProps = context.getBeanFactory().getBean(MessagingProps.class);
        return messagingProps.protocolProps().protocolModes().contains(mode);
    }

    @Override
    public ConfigurationPhase getConfigurationPhase() {
        return REGISTER_BEAN;
    }
}
