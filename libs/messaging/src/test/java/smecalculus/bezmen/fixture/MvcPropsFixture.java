package smecalculus.bezmen.fixture;

import static smecalculus.bezmen.configuration.WebMode.SPRING_MVC;

import smecalculus.bezmen.configuration.WebProps;

public class MvcPropsFixture {
    public static WebProps.Builder mvcProps() {
        return WebProps.builder().webMode(SPRING_MVC);
    }
}
