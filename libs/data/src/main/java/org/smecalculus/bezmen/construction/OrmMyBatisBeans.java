package org.smecalculus.bezmen.construction;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

import static org.smecalculus.bezmen.modeling.OrmMode.MY_BATIS;

@Configuration(proxyBeanMethods = false)
@ConditionalOnOrmMode(MY_BATIS)
@MapperScan("org.smecalculus.bezmen.data.mybatis")
public class OrmMyBatisBeans {
}
