package smecalculus.bezmen.messaging;

import java.util.UUID;

public class SepulkaNewResponseEg {
    public static class Pojos {
        public static SepulkaNewResponseEdge sepulkaNewResponseEdge() {
            var responseEdge = new SepulkaNewResponseEdge();
            responseEdge.setExternalId(UUID.randomUUID().toString());
            return responseEdge;
        }

        public static SepulkaNewResponseEdge sepulkaNewResponseEdge(String externalId) {
            var responseEdge = sepulkaNewResponseEdge();
            responseEdge.setExternalId(externalId);
            return responseEdge;
        }
    }
}
