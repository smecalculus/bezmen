package smecalculus.bezmen.exterior.messaging;

public class SepulkaRegisterSliceEg {
    public static final String NAME = "foo";

    public static class Pojos {
        public static SepulkaRegisterSlice sepulkaRegisterSlice() {
            return new SepulkaRegisterSlice(NAME);
        }

        public static SepulkaRegisterSliceMsg sepulkaRegisterSliceMsg() {
            var msg = new SepulkaRegisterSliceMsg();
            msg.setName(NAME);
            return msg;
        }
    }
}
