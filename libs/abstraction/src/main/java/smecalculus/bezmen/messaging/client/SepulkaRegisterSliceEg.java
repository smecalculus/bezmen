package smecalculus.bezmen.messaging.client;

public class SepulkaRegisterSliceEg {
    public static final String NAME = "foo";

    public static class Pojos {
        public static SepulkaRegisterSlice sepulkaRegisterSlice() {
            return new SepulkaRegisterSlice(NAME);
        }
    }
}
