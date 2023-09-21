package smecalculus.bezmen.fixture;

import static smecalculus.bezmen.fixture.MvcPropsFixture.mvcProps;

import smecalculus.bezmen.configuration.HttpProps;

public class HttpPropsFixture {
    public static HttpProps.Builder httpProps() {
        return HttpProps.builder().webProps(mvcProps().build());
    }
}
