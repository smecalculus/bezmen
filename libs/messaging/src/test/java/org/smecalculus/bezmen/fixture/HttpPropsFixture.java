package org.smecalculus.bezmen.fixture;

import static org.smecalculus.bezmen.fixture.MvcPropsFixture.mvcProps;

import org.smecalculus.bezmen.configuration.spec.HttpProps;

public class HttpPropsFixture {
    public static HttpProps.Builder httpProps() {
        return HttpProps.builder().webProps(mvcProps().build());
    }
}
