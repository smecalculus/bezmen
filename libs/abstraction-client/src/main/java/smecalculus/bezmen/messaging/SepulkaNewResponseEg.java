package smecalculus.bezmen.messaging;

import java.util.UUID;

public class SepulkaNewResponseEg {

    public static class Pojos {

        public static SepulkaNewResponseEdge sepulkaNewResponseEdge() {
            var responseEdge = new SepulkaNewResponseEdge();
            responseEdge.setId(UUID.randomUUID().toString());
            return responseEdge;
        }

        public static SepulkaNewResponseEdge sepulkaNewResponseEdge(UUID id) {
            var responseEdge = sepulkaNewResponseEdge();
            responseEdge.setId(id.toString());
            return responseEdge;
        }
    }
}
