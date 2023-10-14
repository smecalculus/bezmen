package smecalculus.bezmen.core;

import java.util.UUID;

public class SepulkaNewRequestEg {
    public static class Pojos {
        public static SepulkaNewRequest sepulkaNewRequest() {
            return Builders.sepulkaNewRequest().build();
        }
    }

    public static class Builders {
        public static SepulkaNewRequest.Builder sepulkaNewRequest() {
            return SepulkaNewRequest.builder().externalId(UUID.randomUUID().toString());
        }
    }
}
