package smecalculus.bezmen.construction;

import static smecalculus.bezmen.configuration.OrmMode.MY_BATIS;
import static smecalculus.bezmen.configuration.OrmMode.SPRING_DATA;
import static smecalculus.bezmen.configuration.WebMode.SPRING_MVC;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import smecalculus.bezmen.core.SepulkaConverter;
import smecalculus.bezmen.core.SepulkaConverterImpl;
import smecalculus.bezmen.core.SepulkaService;
import smecalculus.bezmen.core.SepulkaServiceImpl;
import smecalculus.bezmen.messaging.SepulkaClient;
import smecalculus.bezmen.messaging.SepulkaClientImpl;
import smecalculus.bezmen.messaging.SepulkaMsgMapper;
import smecalculus.bezmen.messaging.SepulkaMsgMapperImpl;
import smecalculus.bezmen.messaging.springmvc.SepulkaController;
import smecalculus.bezmen.storage.SepulkaDao;
import smecalculus.bezmen.storage.SepulkaDaoMyBatis;
import smecalculus.bezmen.storage.SepulkaDaoSpringData;
import smecalculus.bezmen.storage.SepulkaRecMapper;
import smecalculus.bezmen.storage.SepulkaRecMapperImpl;
import smecalculus.bezmen.storage.mybatis.SepulkaSqlMapper;
import smecalculus.bezmen.storage.springdata.SepulkaRepository;
import smecalculus.bezmen.validation.EdgeValidator;

@Import({ConfigBeans.class, ValidationBeans.class, MessagingBeans.class, StorageBeans.class})
//@EnableAutoConfiguration(
//        exclude = {
//            LiquibaseAutoConfiguration.class,
//            AopAutoConfiguration.class,
//            DataSourceHealthContributorAutoConfiguration.class,
//            DiskSpaceHealthContributorAutoConfiguration.class,
//            EmbeddedWebServerFactoryCustomizerAutoConfiguration.class,
//            PersistenceExceptionTranslationAutoConfiguration.class,
//            SpringDataWebAutoConfiguration.class,
//            HealthContributorAutoConfiguration.class,
//            HttpMessageConvertersAutoConfiguration.class,
//            LifecycleAutoConfiguration.class,
//            MultipartAutoConfiguration.class,
//            PropertyPlaceholderAutoConfiguration.class,
//            RestTemplateAutoConfiguration.class,
//            TaskExecutionAutoConfiguration.class,
//            TaskSchedulingAutoConfiguration.class
//        })
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
    SepulkaClient sepulkaClient(EdgeValidator validator, SepulkaService service, SepulkaConverter converter) {
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
