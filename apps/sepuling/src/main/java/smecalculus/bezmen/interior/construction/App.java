package smecalculus.bezmen.interior.construction;

import static smecalculus.bezmen.interior.configuration.MessageMappingMode.SPRING_MVC;
import static smecalculus.bezmen.interior.configuration.StateMappingMode.MY_BATIS;
import static smecalculus.bezmen.interior.configuration.StateMappingMode.SPRING_DATA;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import smecalculus.bezmen.exterior.messaging.SepulkaClient;
import smecalculus.bezmen.exterior.messaging.SepulkaMsgMapper;
import smecalculus.bezmen.exterior.messaging.SepulkaMsgMapperImpl;
import smecalculus.bezmen.interior.core.SepulkaService;
import smecalculus.bezmen.interior.core.SepulkaServiceImpl;
import smecalculus.bezmen.interior.core.SepulkaSliceMapper;
import smecalculus.bezmen.interior.core.SepulkaSliceMapperImpl;
import smecalculus.bezmen.interior.messaging.SepulkaClientImpl;
import smecalculus.bezmen.interior.messaging.springmvc.SepulkaController;
import smecalculus.bezmen.interior.storage.SepulkaDao;
import smecalculus.bezmen.interior.storage.SepulkaDaoMyBatis;
import smecalculus.bezmen.interior.storage.SepulkaDaoSpringData;
import smecalculus.bezmen.interior.storage.SepulkaRecMapper;
import smecalculus.bezmen.interior.storage.SepulkaRecMapperImpl;
import smecalculus.bezmen.interior.storage.mybatis.SepulkaSqlMapper;
import smecalculus.bezmen.interior.storage.springdata.SepulkaRepository;
import smecalculus.bezmen.interior.validation.EdgeValidator;

@Import({ValidationBeans.class, ConfigBeans.class, MessagingBeans.class, StorageBeans.class})
@PropertySource("classpath:application.properties")
@Configuration(proxyBeanMethods = false)
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    @ConditionalOnMessageMappingModes(SPRING_MVC)
    SepulkaController sepulkaControllerSpringMvc(SepulkaClient client) {
        return new SepulkaController(client);
    }

    @Bean
    SepulkaMsgMapper sepulkaMsgMapper() {
        return new SepulkaMsgMapperImpl();
    }

    @Bean
    SepulkaClient sepulkaClient(EdgeValidator validator, SepulkaMsgMapper mapper, SepulkaService service) {
        return new SepulkaClientImpl(validator, mapper, service);
    }

    @Bean
    SepulkaSliceMapper sepulkaSliceMapper() {
        return new SepulkaSliceMapperImpl();
    }

    @Bean
    SepulkaService sepulkaService(SepulkaSliceMapper mapper, SepulkaDao dao) {
        return new SepulkaServiceImpl(mapper, dao);
    }

    @Bean
    SepulkaRecMapper sepulkaRecMapper() {
        return new SepulkaRecMapperImpl();
    }

    @Bean
    @ConditionalOnStateMappingMode(SPRING_DATA)
    SepulkaDaoSpringData sepulkaDaoSpringData(SepulkaRecMapper mapper, SepulkaRepository repository) {
        return new SepulkaDaoSpringData(mapper, repository);
    }

    @Bean
    @ConditionalOnStateMappingMode(MY_BATIS)
    SepulkaDaoMyBatis sepulkaDaoMyBatis(SepulkaRecMapper recMapper, SepulkaSqlMapper sqlMapper) {
        return new SepulkaDaoMyBatis(recMapper, sqlMapper);
    }
}
