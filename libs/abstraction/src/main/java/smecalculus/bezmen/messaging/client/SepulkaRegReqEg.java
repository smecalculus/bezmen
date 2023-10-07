package smecalculus.bezmen.messaging.client;

public class SepulkaRegReqEg {
    public static final String NAME = "foo";

    public static class Pojos {
        public static SepulkaRegReq sepulkaRegReq() {
            return new SepulkaRegReq(NAME);
        }
    }
}
