package org.smecalculus.bezmen.fixture;

import org.smecalculus.bezmen.configuration.HttpProps;

import static org.smecalculus.bezmen.fixture.MvcPropsFixture.mvcProps;

public class HttpPropsFixture {
    public static HttpProps.Builder httpProps() {
        return HttpProps.builder()
                .webProps(mvcProps().build());
    }
}
