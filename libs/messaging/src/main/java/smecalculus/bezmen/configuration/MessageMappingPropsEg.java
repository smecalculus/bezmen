package smecalculus.bezmen.configuration;

import static java.util.Collections.singleton;
import static smecalculus.bezmen.configuration.MessageMappingMode.SPRING_WEB_MVC;

public class MessageMappingPropsEg {
    public static class Builders {
        public static MessageMappingProps.Builder messageMappingProps() {
            return MessageMappingProps.builder().mappingModes(singleton(SPRING_WEB_MVC));
        }
    }
}
