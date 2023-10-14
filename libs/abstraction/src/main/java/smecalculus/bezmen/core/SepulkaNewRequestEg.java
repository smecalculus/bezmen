package smecalculus.bezmen.core;

public class SepulkaNewRequestEg {
    public static final String NAME = "foo";

    public static class Pojos {
        public static SepulkaNewRequest sepulkaNewRequest() {
            return new SepulkaNewRequest(NAME);
        }
    }
}
