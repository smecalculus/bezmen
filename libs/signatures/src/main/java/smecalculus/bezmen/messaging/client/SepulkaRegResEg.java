package smecalculus.bezmen.messaging.client;

import java.util.UUID;

public class SepulkaRegResEg {
    public static final String NAME = "foo";

    public static class Pojos {
        public static SepulkaRegRes sepulkaRegRes() {
            return new SepulkaRegRes(UUID.randomUUID(), NAME);
        }

        public static SepulkaRegRes sepulkaRegRes(String name) {
            return new SepulkaRegRes(UUID.randomUUID(), name);
        }

        public static SepulkaRegRes sepulkaRegRes(UUID id) {
            return new SepulkaRegRes(id, NAME);
        }
    }
}
