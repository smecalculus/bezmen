package smecalculus.bezmen.configuration;

import static smecalculus.bezmen.configuration.MessageMappingMode.SPRING_WEB;

public class MessageMappingPropsEg {
    public static class Builders {
        public static MessageMappingProps.Builder messageMappingProps() {
            return MessageMappingProps.builder().mappingMode(SPRING_WEB);
        }
    }
}
