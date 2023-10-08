package smecalculus.bezmen.interior.construction;

import static smecalculus.bezmen.interior.configuration.StateMappingMode.MY_BATIS;

import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@ConditionalOnStateMappingMode(MY_BATIS)
@MapperScan(basePackages = "smecalculus.bezmen.interior.storage.mybatis")
@Configuration(proxyBeanMethods = false)
public class MappingMyBatisBeans {

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        return factoryBean.getObject();
    }
}