package smecalculus.bezmen.construction;

import static smecalculus.bezmen.configuration.StateMappingMode.MY_BATIS;
import static smecalculus.bezmen.configuration.StateMappingMode.SPRING_DATA;
import static smecalculus.bezmen.configuration.StorageProtocolMode.H2;
import static smecalculus.bezmen.configuration.StorageProtocolMode.POSTGRES;

import org.springframework.context.annotation.Bean;
import smecalculus.bezmen.configuration.ServerSide.StorageProps;
import smecalculus.bezmen.configuration.ServerSideEg;

public class StoragePropsBeans {

    public static class SpringDataPostgres {
        @Bean
        public StorageProps storageProps() {
            return ServerSideEg.storageProps(SPRING_DATA, POSTGRES).build();
        }
    }

    public static class SpringDataH2 {
        @Bean
        public StorageProps storageProps() {
            return ServerSideEg.storageProps(SPRING_DATA, H2).build();
        }
    }

    public static class MyBatisPostgres {
        @Bean
        public StorageProps storageProps() {
            return ServerSideEg.storageProps(MY_BATIS, POSTGRES).build();
        }
    }

    public static class MyBatisH2 {
        @Bean
        public StorageProps storageProps() {
            return ServerSideEg.storageProps(MY_BATIS, H2).build();
        }
    }
}
