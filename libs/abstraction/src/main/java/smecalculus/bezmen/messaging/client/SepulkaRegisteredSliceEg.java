package smecalculus.bezmen.messaging.client;

import java.util.UUID;

public class SepulkaRegisteredSliceEg {

    public static class Pojos {
        public static SepulkaRegisteredSlice sepulkaRegisteredSlice() {
            return new SepulkaRegisteredSlice(UUID.randomUUID());
        }

        public static SepulkaRegisteredSlice sepulkaRegisteredSlice(UUID id) {
            return new SepulkaRegisteredSlice(id);
        }
    }
}
