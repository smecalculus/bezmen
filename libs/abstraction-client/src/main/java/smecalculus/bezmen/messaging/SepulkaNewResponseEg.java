package smecalculus.bezmen.messaging;

import java.util.UUID;

public class SepulkaNewResponseEg {

    public static class Pojos {

        public static SepulkaNewResponseMsg sepulkaNewResponseMsg() {
            return new SepulkaNewResponseMsg().setId(UUID.randomUUID().toString());
        }

        public static SepulkaNewResponseMsg sepulkaNewResponseMsg(UUID id) {
            return sepulkaNewResponseMsg().setId(id.toString());
        }
    }
}
