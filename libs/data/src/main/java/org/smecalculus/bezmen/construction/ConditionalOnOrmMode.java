package org.smecalculus.bezmen.construction;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.smecalculus.bezmen.modeling.OrmMode;
import org.springframework.context.annotation.Conditional;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Conditional(OrmModeCondition.class)
public @interface ConditionalOnOrmMode {
    OrmMode value();
}
