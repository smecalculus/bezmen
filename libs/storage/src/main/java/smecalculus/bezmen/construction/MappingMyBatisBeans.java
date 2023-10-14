package smecalculus.bezmen.construction;

import static smecalculus.bezmen.configuration.StateMappingMode.MY_BATIS;

import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@ConditionalOnStateMappingMode(MY_BATIS)
@MapperScan(basePackages = "smecalculus.bezmen.storage.mybatis")
@Configuration(proxyBeanMethods = false)
public class MappingMyBatisBeans {

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        var factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        return factoryBean.getObject();
    }
}
