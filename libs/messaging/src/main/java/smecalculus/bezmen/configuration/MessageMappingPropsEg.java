package smecalculus.bezmen.configuration;

import static smecalculus.bezmen.configuration.MessageMappingMode.SPRING_MVC;

import java.util.Set;

public class MessageMappingPropsEg {
    public static class Builders {
        public static MessageMappingProps.Builder messageMappingProps() {
            return MessageMappingProps.builder().mappingModes(Set.of(SPRING_MVC));
        }
    }
}
