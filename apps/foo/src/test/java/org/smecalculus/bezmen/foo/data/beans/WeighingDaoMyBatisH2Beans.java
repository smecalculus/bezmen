package org.smecalculus.bezmen.foo.data.beans;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.smecalculus.bezmen.foo.WeighingModelMapper;
import org.smecalculus.bezmen.foo.data.WeighingDao;
import org.smecalculus.bezmen.foo.data.WeighingDaoMyBatisImpl;
import org.smecalculus.bezmen.foo.data.mybatis.WeighingSqlMapper;
import org.smecalculus.bezmen.schema.SchemaBeans;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Import(SchemaBeans.class)
@Configuration(proxyBeanMethods = false)
@MapperScan("org.smecalculus.bezmen.foo.data.mybatis")
public class WeighingDaoMyBatisH2Beans {

    @Bean
    public WeighingDao underTest(WeighingModelMapper modelMapper, WeighingSqlMapper sqlMapper) {
        return new WeighingDaoMyBatisImpl(modelMapper, sqlMapper);
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:mem:mybatis;DB_CLOSE_DELAY=-1;DATABASE_TO_UPPER=false");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        return dataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        return factoryBean.getObject();
    }
}