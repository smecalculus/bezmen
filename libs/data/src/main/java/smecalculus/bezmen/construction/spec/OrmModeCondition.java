package smecalculus.bezmen.construction.spec;

import static org.springframework.context.annotation.ConfigurationCondition.ConfigurationPhase.REGISTER_BEAN;

import java.util.Map;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.ConfigurationCondition;
import org.springframework.core.type.AnnotatedTypeMetadata;
import smecalculus.bezmen.configuration.spec.DataProps;
import smecalculus.bezmen.configuration.spec.OrmMode;

class OrmModeCondition implements ConfigurationCondition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Map<String, Object> attributes = metadata.getAnnotationAttributes(ConditionalOnOrmMode.class.getName());
        OrmMode mode = (OrmMode) attributes.get("value");
        DataProps props = context.getBeanFactory().getBean(DataProps.class);
        return mode == props.ormProps().mode();
    }

    @Override
    public ConfigurationPhase getConfigurationPhase() {
        return REGISTER_BEAN;
    }
}
