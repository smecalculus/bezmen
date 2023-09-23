package smecalculus.bezmen.configuration;

import static smecalculus.bezmen.configuration.MvcPropsEg.Builders.mvcProps;

public class HttpPropsEg {
    public static class Builders {
        public static HttpProps.Builder httpProps() {
            return HttpProps.builder().webProps(mvcProps().build());
        }
    }
}
