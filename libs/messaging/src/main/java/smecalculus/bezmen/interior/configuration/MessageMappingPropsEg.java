package smecalculus.bezmen.interior.configuration;

import java.util.Set;

public class MessageMappingPropsEg {
    public static class Builders {
        public static MessageMappingProps.Builder messageMappingProps() {
            return MessageMappingProps.builder().mappingModes(Set.of(MessageMappingMode.SPRING_MVC));
        }
    }
}
