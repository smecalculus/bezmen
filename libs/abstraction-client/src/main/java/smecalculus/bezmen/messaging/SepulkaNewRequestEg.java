package smecalculus.bezmen.messaging;

import java.util.UUID;

public class SepulkaNewRequestEg {
    public static class Pojos {
        public static SepulkaNewRequestEdge sepulkaNewRequestEdge() {
            var requestEdge = new SepulkaNewRequestEdge();
            requestEdge.setExternalId(UUID.randomUUID().toString());
            return requestEdge;
        }

        public static SepulkaNewRequestEdge sepulkaNewRequestEdge(String id) {
            var requestEdge = sepulkaNewRequestEdge();
            requestEdge.setExternalId(id);
            return requestEdge;
        }
    }
}
