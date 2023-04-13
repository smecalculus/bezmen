package org.smecalculus.bezmen.construction;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

import static org.smecalculus.bezmen.modeling.OrmMode.SPRING_DATA;

@Configuration(proxyBeanMethods = false)
@ConditionalOnOrmMode(SPRING_DATA)
@EnableJdbcRepositories("org.smecalculus.bezmen.data.springdata")
public class OrmSpringDataBeans {
}
