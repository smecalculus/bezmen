package smecalculus.bezmen.core;

import java.util.UUID;

public class SepulkaNewResponseEg {

    public static class Pojos {
        public static SepulkaNewResponse sepulkaNewResponse() {
            return sepulkaNewResponse(UUID.randomUUID());
        }

        public static SepulkaNewResponse sepulkaNewResponse(UUID id) {
            return new SepulkaNewResponse(id);
        }
    }
}
