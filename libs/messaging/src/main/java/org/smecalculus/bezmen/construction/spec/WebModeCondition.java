package org.smecalculus.bezmen.construction.spec;

import static java.util.Objects.nonNull;
import static org.smecalculus.bezmen.configuration.spec.MessagingProtocol.HTTP;
import static org.springframework.context.annotation.ConfigurationCondition.ConfigurationPhase.REGISTER_BEAN;

import java.util.Map;
import org.smecalculus.bezmen.configuration.spec.HttpProps;
import org.smecalculus.bezmen.configuration.spec.MessagingProps;
import org.smecalculus.bezmen.configuration.spec.WebMode;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.ConfigurationCondition;
import org.springframework.core.type.AnnotatedTypeMetadata;

class WebModeCondition implements ConfigurationCondition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Map<String, Object> attributes = metadata.getAnnotationAttributes(ConditionalOnWebMode.class.getName());
        WebMode mode = (WebMode) attributes.get("value");
        MessagingProps messagingProps = context.getBeanFactory().getBean(MessagingProps.class);
        if (!messagingProps.protocolProps().types().contains(HTTP)) {
            return false;
        }
        HttpProps httpProps = messagingProps.protocolProps().httpProps();
        return nonNull(httpProps) && mode == httpProps.webProps().webMode();
    }

    @Override
    public ConfigurationPhase getConfigurationPhase() {
        return REGISTER_BEAN;
    }
}
