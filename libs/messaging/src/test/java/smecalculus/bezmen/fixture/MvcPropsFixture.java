package smecalculus.bezmen.fixture;

import static smecalculus.bezmen.configuration.spec.WebMode.SPRING_MVC;

import smecalculus.bezmen.configuration.spec.WebProps;

public class MvcPropsFixture {
    public static WebProps.Builder mvcProps() {
        return WebProps.builder().webMode(SPRING_MVC);
    }
}
