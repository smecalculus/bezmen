package org.smecalculus.bezmen.construction.spec;

import static org.smecalculus.bezmen.configuration.spec.OrmMode.MY_BATIS;
import static org.smecalculus.bezmen.configuration.spec.OrmMode.SPRING_DATA;
import static org.smecalculus.bezmen.configuration.spec.WebMode.SPRING_MVC;

import org.smecalculus.bezmen.data.impl.SepulkaDaoMyBatis;
import org.smecalculus.bezmen.data.impl.SepulkaDaoSpringData;
import org.smecalculus.bezmen.data.spec.SepulkaDao;
import org.smecalculus.bezmen.data.spec.SepulkaRecMapper;
import org.smecalculus.bezmen.data.spec.SepulkaRecMapperImpl;
import org.smecalculus.bezmen.data.spec.mybatis.SepulkaSqlMapper;
import org.smecalculus.bezmen.data.spec.springdata.SepulkaRepository;
import org.smecalculus.bezmen.messaging.impl.SepulkaClientImpl;
import org.smecalculus.bezmen.messaging.impl.springmvc.SepulkaController;
import org.smecalculus.bezmen.messaging.spec.SepulkaClient;
import org.smecalculus.bezmen.messaging.spec.SepulkaMsgMapper;
import org.smecalculus.bezmen.messaging.spec.SepulkaMsgMapperImpl;
import org.smecalculus.bezmen.service.impl.SepulkaConverterImpl;
import org.smecalculus.bezmen.service.impl.SepulkaServiceImpl;
import org.smecalculus.bezmen.service.spec.SepulkaConverter;
import org.smecalculus.bezmen.service.spec.SepulkaService;
import org.smecalculus.bezmen.validation.spec.BezmenValidator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.health.HealthContributorAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.jdbc.DataSourceHealthContributorAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.system.DiskSpaceHealthContributorAutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.boot.autoconfigure.context.LifecycleAutoConfiguration;
import org.springframework.boot.autoconfigure.context.PropertyPlaceholderAutoConfiguration;
import org.springframework.boot.autoconfigure.dao.PersistenceExceptionTranslationAutoConfiguration;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration;
import org.springframework.boot.autoconfigure.http.HttpMessageConvertersAutoConfiguration;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.boot.autoconfigure.task.TaskExecutionAutoConfiguration;
import org.springframework.boot.autoconfigure.task.TaskSchedulingAutoConfiguration;
import org.springframework.boot.autoconfigure.web.client.RestTemplateAutoConfiguration;
import org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import({ConfigBeans.class, ValidationBeans.class, MessagingBeans.class, DataBeans.class})
@EnableAutoConfiguration(
        exclude = {
            LiquibaseAutoConfiguration.class,
            AopAutoConfiguration.class,
            DataSourceHealthContributorAutoConfiguration.class,
            DiskSpaceHealthContributorAutoConfiguration.class,
            EmbeddedWebServerFactoryCustomizerAutoConfiguration.class,
            PersistenceExceptionTranslationAutoConfiguration.class,
            SpringDataWebAutoConfiguration.class,
            HealthContributorAutoConfiguration.class,
            HttpMessageConvertersAutoConfiguration.class,
            LifecycleAutoConfiguration.class,
            MultipartAutoConfiguration.class,
            PropertyPlaceholderAutoConfiguration.class,
            RestTemplateAutoConfiguration.class,
            TaskExecutionAutoConfiguration.class,
            TaskSchedulingAutoConfiguration.class
        })
@Configuration(proxyBeanMethods = false)
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    @ConditionalOnWebMode(SPRING_MVC)
    SepulkaController sepulkaController(SepulkaClient client, SepulkaMsgMapper mapper) {
        return new SepulkaController(client, mapper);
    }

    @Bean
    SepulkaMsgMapper sepulkaMsgMapper() {
        return new SepulkaMsgMapperImpl();
    }

    @Bean
    SepulkaClient sepulkaClient(BezmenValidator validator, SepulkaService service, SepulkaConverter converter) {
        return new SepulkaClientImpl(validator, service, converter);
    }

    @Bean
    SepulkaService sepulkaService(SepulkaDao sepulkaDao) {
        return new SepulkaServiceImpl(sepulkaDao);
    }

    @Bean
    SepulkaConverter sepulkaConverter() {
        return new SepulkaConverterImpl();
    }

    @Bean
    @ConditionalOnOrmMode(SPRING_DATA)
    SepulkaDaoSpringData sepulkaDaoSpringData(SepulkaRecMapper mapper, SepulkaRepository repository) {
        return new SepulkaDaoSpringData(mapper, repository);
    }

    @Bean
    @ConditionalOnOrmMode(MY_BATIS)
    SepulkaDaoMyBatis sepulkaDaoMyBatis(SepulkaRecMapper recMapper, SepulkaSqlMapper sqlMapper) {
        return new SepulkaDaoMyBatis(recMapper, sqlMapper);
    }

    @Bean
    SepulkaRecMapper sepulkaRecMapper() {
        return new SepulkaRecMapperImpl();
    }
}
