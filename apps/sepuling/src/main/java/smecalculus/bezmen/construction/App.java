package smecalculus.bezmen.construction;

import static smecalculus.bezmen.configuration.MessageMappingMode.SPRING_MVC;
import static smecalculus.bezmen.configuration.StateMappingMode.MY_BATIS;
import static smecalculus.bezmen.configuration.StateMappingMode.SPRING_DATA;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import smecalculus.bezmen.core.SepulkaService;
import smecalculus.bezmen.core.SepulkaServiceImpl;
import smecalculus.bezmen.core.SepulkaSliceMapper;
import smecalculus.bezmen.core.SepulkaSliceMapperImpl;
import smecalculus.bezmen.messaging.SepulkaClient;
import smecalculus.bezmen.messaging.SepulkaClientImpl;
import smecalculus.bezmen.messaging.SepulkaMessageMapper;
import smecalculus.bezmen.messaging.SepulkaMessageMapperImpl;
import smecalculus.bezmen.messaging.springmvc.SepulkaController;
import smecalculus.bezmen.storage.SepulkaDao;
import smecalculus.bezmen.storage.SepulkaDaoMyBatis;
import smecalculus.bezmen.storage.SepulkaDaoSpringData;
import smecalculus.bezmen.storage.SepulkaStateMapper;
import smecalculus.bezmen.storage.SepulkaStateMapperImpl;
import smecalculus.bezmen.storage.mybatis.SepulkaSqlMapper;
import smecalculus.bezmen.storage.springdata.SepulkaRepository;
import smecalculus.bezmen.validation.EdgeValidator;

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
    SepulkaMessageMapper sepulkaMessageMapper() {
        return new SepulkaMessageMapperImpl();
    }

    @Bean
    SepulkaClient sepulkaClient(EdgeValidator validator, SepulkaMessageMapper mapper, SepulkaService service) {
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
    SepulkaStateMapper sepulkaStateMapper() {
        return new SepulkaStateMapperImpl();
    }

    @Bean
    @ConditionalOnStateMappingMode(SPRING_DATA)
    SepulkaDaoSpringData sepulkaDaoSpringData(SepulkaStateMapper mapper, SepulkaRepository repository) {
        return new SepulkaDaoSpringData(mapper, repository);
    }

    @Bean
    @ConditionalOnStateMappingMode(MY_BATIS)
    SepulkaDaoMyBatis sepulkaDaoMyBatis(SepulkaStateMapper recMapper, SepulkaSqlMapper sqlMapper) {
        return new SepulkaDaoMyBatis(recMapper, sqlMapper);
    }
}