package org.smecalculus.bezmen.fixture;

import static org.smecalculus.bezmen.configuration.spec.WebMode.SPRING_MVC;

import org.smecalculus.bezmen.configuration.spec.WebProps;

public class MvcPropsFixture {
    public static WebProps.Builder mvcProps() {
        return WebProps.builder().webMode(SPRING_MVC);
    }
}
