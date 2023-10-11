package smecalculus.bezmen.exterior.messaging;

import java.util.UUID;

public class SepulkaRegisteredSliceEg {

    public static class Pojos {
        public static SepulkaRegisteredSlice sepulkaRegisteredSlice() {
            return new SepulkaRegisteredSlice(UUID.randomUUID());
        }

        public static SepulkaRegisteredSlice sepulkaRegisteredSlice(UUID id) {
            return new SepulkaRegisteredSlice(id);
        }

        public static SepulkaRegisteredSliceMsg sepulkaRegisteredSliceMsg(UUID id) {
            var sliceMsg = new SepulkaRegisteredSliceMsg();
            sliceMsg.setId(id.toString());
            return sliceMsg;
        }
    }
}
