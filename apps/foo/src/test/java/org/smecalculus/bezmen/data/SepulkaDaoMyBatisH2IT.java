package org.smecalculus.bezmen.data;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.smecalculus.bezmen.data.mybatis.SepulkaSqlMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;

import javax.sql.DataSource;

@ContextConfiguration
public class SepulkaDaoMyBatisH2IT extends SepulkaDaoIT {

    @Configuration
    @MapperScan("org.smecalculus.bezmen.data.mybatis")
    static class Beans {
        @Bean
        public SepulkaDaoMyBatis underTest(SepulkaRecMapper recMapper, SepulkaSqlMapper sqlMapper) {
            return new SepulkaDaoMyBatis(recMapper, sqlMapper);
        }

        @Bean
        public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
            SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
            factoryBean.setDataSource(dataSource);
            return factoryBean.getObject();
        }
    }
}
