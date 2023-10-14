package smecalculus.bezmen.messaging;

public class SepulkaNewRequestEg {
    public static final String NAME = "foo";

    public static class Pojos {

        public static SepulkaNewRequestEdge sepulkaNewRequestEdge() {
            var requestEdge = new SepulkaNewRequestEdge();
            requestEdge.setName(NAME);
            return requestEdge;
        }
    }
}
