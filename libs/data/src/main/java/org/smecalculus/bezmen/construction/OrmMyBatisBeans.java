package org.smecalculus.bezmen.construction;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

import static org.smecalculus.bezmen.modeling.OrmMode.MY_BATIS;

@Configuration(proxyBeanMethods = false)
@ConditionalOnOrmMode(MY_BATIS)
@MapperScan("org.smecalculus.bezmen.data.mybatis")
public class OrmMyBatisBeans {

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        return factoryBean.getObject();
    }
}
