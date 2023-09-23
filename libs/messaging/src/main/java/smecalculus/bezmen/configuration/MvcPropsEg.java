package smecalculus.bezmen.configuration;

import static smecalculus.bezmen.configuration.WebMode.SPRING_MVC;

public class MvcPropsEg {
    public static class Builders {
        public static WebProps.Builder mvcProps() {
            return WebProps.builder().webMode(SPRING_MVC);
        }
    }
}
