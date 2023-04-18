package org.smecalculus.bezmen.construction;

import org.smecalculus.bezmen.data.SepulkaDao;
import org.smecalculus.bezmen.data.SepulkaDaoSpringData;
import org.smecalculus.bezmen.data.SepulkaRecMapper;
import org.smecalculus.bezmen.data.SepulkaRecMapperImpl;
import org.smecalculus.bezmen.data.springdata.SepulkaRepository;
import org.smecalculus.bezmen.messaging.SepulkaClient;
import org.smecalculus.bezmen.messaging.SepulkaClientImpl;
import org.smecalculus.bezmen.messaging.SepulkaMsgMapper;
import org.smecalculus.bezmen.messaging.SepulkaMsgMapperImpl;
import org.smecalculus.bezmen.messaging.springmvc.SepulkaController;
import org.smecalculus.bezmen.modeling.SepulkaConverter;
import org.smecalculus.bezmen.modeling.SepulkaService;
import org.smecalculus.bezmen.service.SepulkaConverterImpl;
import org.smecalculus.bezmen.service.SepulkaServiceImpl;
import org.smecalculus.bezmen.validation.BezmenValidator;
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

import static org.smecalculus.bezmen.configuration.WebMode.SPRING_MVC;

@Import({
        ConfigBeans.class,
        ValidationBeans.class,
        MessagingBeans.class,
        DataBeans.class
})
@EnableAutoConfiguration(exclude = {
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
    SepulkaController sepulkaController(SepulkaClient client,
                                        SepulkaMsgMapper mapper) {
        return new SepulkaController(client, mapper);
    }

    @Bean
    public SepulkaMsgMapper sepulkaMsgMapper() {
        return new SepulkaMsgMapperImpl();
    }

    @Bean
    SepulkaClient sepulkaClient(BezmenValidator validator,
                                SepulkaService service,
                                SepulkaConverter converter) {
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
    public SepulkaDao sepulkaDao(SepulkaRecMapper mapper,
                                 SepulkaRepository repository) {
        return new SepulkaDaoSpringData(mapper, repository);
    }

    @Bean
    public SepulkaRecMapper sepulkaRecMapper() {
        return new SepulkaRecMapperImpl();
    }
}
