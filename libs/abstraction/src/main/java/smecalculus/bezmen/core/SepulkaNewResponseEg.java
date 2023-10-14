package smecalculus.bezmen.core;

import java.util.UUID;

public class SepulkaNewResponseEg {
    public static class Pojos {
        public static SepulkaNewResponse sepulkaNewResponse() {
            return Builders.sepulkaNewResponse().build();
        }

        public static SepulkaNewResponse sepulkaNewResponse(String externalId) {
            return new SepulkaNewResponse(externalId);
        }
    }

    public static class Builders {
        public static SepulkaNewResponse.Builder sepulkaNewResponse() {
            return SepulkaNewResponse.builder().externalId(UUID.randomUUID().toString());
        }
    }
}
