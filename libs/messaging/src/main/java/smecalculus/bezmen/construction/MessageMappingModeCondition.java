package smecalculus.bezmen.construction;

import static java.util.Objects.nonNull;
import static org.springframework.context.annotation.ConfigurationCondition.ConfigurationPhase.REGISTER_BEAN;
import static smecalculus.bezmen.configuration.MessagingProtocolMode.HTTP;

import java.util.Map;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.ConfigurationCondition;
import org.springframework.core.type.AnnotatedTypeMetadata;
import smecalculus.bezmen.configuration.HttpProps;
import smecalculus.bezmen.configuration.MessageMappingMode;
import smecalculus.bezmen.configuration.MessagingProps;

class MessageMappingModeCondition implements ConfigurationCondition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Map<String, Object> attributes = metadata.getAnnotationAttributes(ConditionalOnMessageMappingMode.class.getName());
        MessageMappingMode mode = (MessageMappingMode) attributes.get("value");
        MessagingProps messagingProps = context.getBeanFactory().getBean(MessagingProps.class);
        if (!messagingProps.protocolProps().protocolModes().contains(HTTP)) {
            return false;
        }
        HttpProps httpProps = messagingProps.protocolProps().httpProps();
        return nonNull(httpProps) && mode == httpProps.mappingProps().mappingMode();
    }

    @Override
    public ConfigurationPhase getConfigurationPhase() {
        return REGISTER_BEAN;
    }
}
