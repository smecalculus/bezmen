package smecalculus.bezmen.fixture;

import static smecalculus.bezmen.fixture.MvcPropsFixture.mvcProps;

import smecalculus.bezmen.configuration.spec.HttpProps;

public class HttpPropsFixture {
    public static HttpProps.Builder httpProps() {
        return HttpProps.builder().webProps(mvcProps().build());
    }
}
