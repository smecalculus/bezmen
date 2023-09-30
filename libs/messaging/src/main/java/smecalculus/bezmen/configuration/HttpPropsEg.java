package smecalculus.bezmen.configuration;

import static smecalculus.bezmen.configuration.MessageMappingPropsEg.Builders.messageMappingProps;

public class HttpPropsEg {
    public static class Builders {
        public static HttpProps.Builder httpProps() {
            return HttpProps.builder().mappingProps(messageMappingProps().build());
        }
    }
}
