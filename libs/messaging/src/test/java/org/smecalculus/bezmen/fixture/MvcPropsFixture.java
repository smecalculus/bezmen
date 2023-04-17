package org.smecalculus.bezmen.fixture;

import org.smecalculus.bezmen.configuration.WebProps;

import static org.smecalculus.bezmen.configuration.WebMode.SPRING_MVC;

public class MvcPropsFixture {
    public static WebProps.Builder mvcProps() {
        return WebProps.builder()
                .webMode(SPRING_MVC);
    }
}
